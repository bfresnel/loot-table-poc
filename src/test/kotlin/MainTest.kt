import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile

@SpringBootTest(classes = [Math::class])
@Profile()
class MainTest {

    @Test
    fun contextloads() {
    }
}
