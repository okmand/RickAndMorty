package com.okmyan.rickandmorty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.okmyan.rickandmorty.charactersscreen.CharactersScreenFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragmentManager = supportFragmentManager
        if (fragmentManager.findFragmentById(R.id.fragment_container) == null) {
            fragmentManager.commit {
                add<CharactersScreenFragment>(R.id.fragment_container, FRAGMENT_CHARACTERS)
            }
        }
    }

    private companion object {

        private const val FRAGMENT_CHARACTERS = "characters"

    }
}
