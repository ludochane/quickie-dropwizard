import com.sun.jersey.api.client.Client;
import io.dropwizard.testing.junit.DropwizardAppRule;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * User: ludochane
 */
public class PlayerResourceTest {

    @ClassRule
    public static final DropwizardAppRule<BadmintonConfiguration> appRule =
            new DropwizardAppRule<BadmintonConfiguration>(BadmintonApplication.class, "src/test/resources/configuration-test.yml");

    @Test
    public void best_should_return_Lin_Dan() {
        Client client = new Client();

        Player player = client.resource("http://localhost:8080/players/best").get(Player.class);

        assertThat(player.getName()).isEqualTo("Lin Dan");
    }
}
