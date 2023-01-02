package services

import fr.bfr.api.CharacterRepository
import fr.bfr.api.DropChanceRepository
import fr.bfr.model.Character
import fr.bfr.model.DropChance
import fr.bfr.services.LootService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import fr.bfr.model.Character as CharacterBfr

class LootServiceTest {

    @Test
    fun `Assert pull method is working`() {
        // Mocking
        val mockCharacterRepository: CharacterRepository = mock()
        val mockDropChanceRepository: DropChanceRepository = mock()
        whenever(mockCharacterRepository.findAll()).thenReturn(listOf(Character(1, "bfr", 1)))
        whenever(mockDropChanceRepository.findAll()).thenReturn(listOf(DropChance(1, 100)))
        val lootService = LootService(mockCharacterRepository, mockDropChanceRepository)

        // NumberOfPull
        val numberOfPull = 1
        val result: List<CharacterBfr> = lootService.pull(numberOfPull)

        // Assertions
        Assertions.assertEquals(result.size, 1)
        Assertions.assertEquals(result[0].id, 1)
        Assertions.assertEquals(result[0].name, "bfr")
        Assertions.assertEquals(result[0].rarity, 1)
    }
}
