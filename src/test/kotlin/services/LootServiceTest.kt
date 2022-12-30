package services

import fr.bfr.services.LootService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile

@SpringBootTest
@Profile("test")
class LootServiceTest(@Autowired val lootService: LootService) {

    /*    @Test
        fun `assert pull method is working`() {
            val characterList: List<Character> = listOf(Character(1, "Roshol", 1))
            val dropChance: List<DropChance> = listOf(DropChance(1, 100.0))

            Assertions.assertEquals(listOf(Character(1, "Roshol", 1)), lootService.pull(characterList, dropChance, 1))
        }*/
}
