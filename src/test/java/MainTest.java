import fr.bfr.MainKt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = MainKt.class)
@Profile("test")
@ActiveProfiles("test")
class MainTest {

    @Test
    void loadContext() {
        //Needed for startup test
    }
}
