package fr.bfr.services

import fr.bfr.api.CharacterRepository
import fr.bfr.api.DropChanceRepository
import fr.bfr.api.LootApi
import fr.bfr.model.Character
import fr.bfr.model.DropChance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.security.SecureRandom

@Service
class LootService @Autowired constructor(
    val characterRepository: CharacterRepository,
    val dropChanceRepository: DropChanceRepository
) : LootApi {
    val secureRandom: SecureRandom = SecureRandom()

    override fun pull(
        numberOfPull: Int
    ): List<Character> {
        val data: List<Character> = characterRepository.findAll();
        val dropChanceList: List<DropChance> = dropChanceRepository.findAll();
        val pulledCharacters: MutableList<Character> = ArrayList()
        val charactersListWithDropChance: MutableList<Character> = ArrayList()
        var counter = 0
        // Setting an array of 100 characters with number of each character matching the chance
        for (dropChance in dropChanceList) {
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
        return pulledCharacters.sortedWith(compareBy { it.rarity })
    }
}
