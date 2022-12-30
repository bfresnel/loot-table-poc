package controller

import fr.bfr.Main
import fr.bfr.model.Character
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(classes = [Main::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class LootControllerTest(
    @Autowired val restTemplate: TestRestTemplate
) {

    @Test
    fun `Integration test of the Pull endpoint`() {
        val entity = restTemplate.getForEntity<List<Character>>("/pull")
        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        Assertions.assertThat(entity.body).isEqualTo(emptyList<Character>())
    }
}
