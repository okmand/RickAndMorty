package com.okmyan.rickandmorty.charactersscreen

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.okmyan.rickandmorty.charactersscreen.adapters.CharacterAdapter
import com.okmyan.rickandmorty.charactersscreen.adapters.LoaderStateAdapter
import com.okmyan.rickandmorty.charactersscreen.databinding.FragmentCharactersScreenBinding
import com.okmyan.rickandmorty.charactersscreen.di.CharactersScreenComponentViewModel
import dagger.Lazy
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CharactersScreenFragment : Fragment(R.layout.fragment_characters_screen) {

    @Inject
    internal lateinit var charactersViewModelFactory: Lazy<CharactersViewModel.Factory>

    @Inject
    lateinit var characterAdapter: CharacterAdapter

    private val charactersViewModel: CharactersViewModel by viewModels {
        charactersViewModelFactory.get()
    }

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<CharactersScreenComponentViewModel>()
            .charactersComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCharactersScreenBinding.bind(view)

        val persons = binding.charactersList
        persons.layoutManager = LinearLayoutManager(binding.root.context)
        persons.adapter = characterAdapter
            .withLoadStateFooter(
                footer = LoaderStateAdapter { characterAdapter.retry() }
            )

        charactersViewModel.charactersFlow.onEach {
            characterAdapter.submitData(it)
        }.launchIn(lifecycleScope)
    }

}
