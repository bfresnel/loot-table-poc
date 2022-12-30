package fr.bfr.services

import fr.bfr.api.LootApi
import fr.bfr.model.Character
import fr.bfr.model.DropChance
import org.springframework.stereotype.Service
import java.security.SecureRandom

@Service
class LootService : LootApi {
    val secureRandom: SecureRandom = SecureRandom()

    override fun pull(
        data: List<Character>,
        dropChances: List<DropChance>,
        numberOfPull: Int
    ): List<Character> {
        val pulledCharacters: MutableList<Character> = ArrayList()
        val charactersListWithDropChance: MutableList<Character> = ArrayList()
        var counter = 0

        // Setting an array of 100 characters with number of each character matching the chance
        for (dropChance in dropChances) {
            while (counter < dropChance.chance) {
                charactersListWithDropChance.add(data[dropChance.rarity - 1])
                counter++
            }
            counter = 0
        }
        while (counter < numberOfPull) {
            pulledCharacters.add(charactersListWithDropChance[secureRandom.nextInt(100)])
            counter += 1
        }
        return pulledCharacters.stream()
            .toList()
    }
}
