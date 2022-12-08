package fr.bfr.api

import fr.bfr.model.Character
import fr.bfr.model.DropChance

interface LootApi {
    fun pull(data: List<Character?>?, dropChances: List<DropChance?>?, numberOfPull: Int?): List<Character?>?
}
