import fr.bfr.Main;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = Main.class)
@Profile("test")
@ActiveProfiles("test")
public class MainTest {

    @Test
    void loadContext() {
    }
}
