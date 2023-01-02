package controller

import fr.bfr.controller.LootController
import fr.bfr.model.Character
import fr.bfr.services.LootService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class LootControllerTest {

    @Test
    fun `Check if pull endpoint is sending correct data`() {
        // Mocking
        val mockLootService: LootService = mock()
        whenever(mockLootService.pull(any())).thenReturn(listOf(Character(1, "bfr", 1)))
        val lootController = LootController(mockLootService)

        // Using the method to test
        val result: ResponseEntity<List<Character>> = lootController.pull()

        // Assertions
        Assertions.assertEquals(HttpStatus.OK, result.statusCode)
        result.body?.let { Assertions.assertEquals(1, it.size) }
        Assertions.assertEquals(true, result.body?.isNotEmpty() ?: false)
    }
}
