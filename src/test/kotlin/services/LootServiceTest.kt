package services

import fr.bfr.Main
import fr.bfr.model.Character
import fr.bfr.model.DropChance
import fr.bfr.services.LootService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import fr.bfr.model.Character as CharacterBfr

@SpringBootTest(classes = [Main::class])
@ActiveProfiles("test")
class LootServiceTest(@Autowired val lootService: LootService) {

    @Test
    fun `Assert pull method is working`() {
        //data
        val data: List<CharacterBfr> = generateCharacterList()
        //DropChance
        val dropChance: List<DropChance> = generateDropChanceList()
        //NumberOfPull
        val numberOfPull = 1
        val result: List<CharacterBfr> = lootService.pull(data, dropChance, numberOfPull)
        Assertions.assertEquals(result.size, 1)
        Assertions.assertEquals(result[0].id, 1)
        Assertions.assertEquals(result[0].name, "bfr")
        Assertions.assertEquals(result[0].rarity, 1)
    }

    fun generateCharacterList(): List<CharacterBfr> {
        return listOf(Character(1, "bfr", 1))
    }

    fun generateDropChanceList(): List<DropChance> {
        return listOf(DropChance(1, 100.0))
    }
}
