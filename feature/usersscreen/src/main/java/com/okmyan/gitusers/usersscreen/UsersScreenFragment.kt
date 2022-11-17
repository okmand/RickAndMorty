package com.okmyan.gitusers.usersscreen

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.okmyan.gitusers.usersscreen.databinding.FragmentUsersScreenBinding
import com.okmyan.gitusers.usersscreen.di.UsersScreenComponentViewModel
import dagger.Lazy
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class UsersScreenFragment : Fragment(R.layout.fragment_users_screen) {

    @Inject
    internal lateinit var usersViewModelFactory: Lazy<UsersViewModel.Factory>

    private val usersViewModel: UsersViewModel by viewModels {
        usersViewModelFactory.get()
    }

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<UsersScreenComponentViewModel>()
            .usersComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentUsersScreenBinding.bind(view)

        usersViewModel.data.onEach { data ->
            binding.text.text = data
        }.launchIn(lifecycleScope)
    }

}