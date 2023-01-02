package fr.bfr.api

import fr.bfr.model.Character

interface LootApi {
    fun pull(numberOfPull: Int): List<Character>
}
