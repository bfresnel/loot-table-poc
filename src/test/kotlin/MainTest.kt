import fr.bfr.Main
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(classes = [Main::class])
@ActiveProfiles("test")
class MainTest {

    @Test
    fun `Testing if the context is loading`() {
        //We are just checking there is no configuration problem
    }
}
