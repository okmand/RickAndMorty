package com.okmyan.rickandmorty.charactersscreen.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.okmyan.rickandmorty.ui_kit.R
import com.okmyan.rickandmorty.charactersscreen.databinding.CharacterCardBinding
import com.okmyan.rickandmorty.domain.models.AliveStatus
import com.okmyan.rickandmorty.domain.models.Character
import com.okmyan.rickandmorty.domain.models.DeadStatus
import com.okmyan.rickandmorty.domain.models.UnknownStatus
import com.squareup.picasso.Picasso
import javax.inject.Inject

class CharacterAdapter @Inject constructor() :
    PagingDataAdapter<Character, CharacterAdapter.CharactersViewHolder>(CharacterComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CharacterCardBinding.inflate(inflater, parent, false)
        return CharactersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class CharactersViewHolder(private val binding: CharacterCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context

        fun bind(character: Character) = with(binding) {
            val icStatus = when (character.status) {
                is AliveStatus -> R.drawable.ic_status_alive
                is UnknownStatus -> R.drawable.ic_status_unknown
                is DeadStatus -> R.drawable.ic_status_dead
            }
            val drawableStatus = AppCompatResources.getDrawable(context, icStatus)

            characterName.text = character.name
            iconLifeStatus.setImageDrawable(drawableStatus)
            lifeStatus.text = character.status.value

            val imageUri = Uri.parse(character.image)
            Picasso.get().load(imageUri)
                .placeholder(R.drawable.ic_ram_avatar)
                .error(R.drawable.ic_ram_avatar)
                .into(characterAvatar)
        }

    }

    object CharacterComparator : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Character, newItem: Character) =
            oldItem == newItem
    }

}
