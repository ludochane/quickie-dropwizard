import io.dropwizard.testing.junit.DropwizardAppRule;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.ClassRule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * User: ludochane
 */
public class PlayerFullTest {

    @ClassRule
    public static final DropwizardAppRule<BadmintonConfiguration> appRule =
            new DropwizardAppRule<BadmintonConfiguration>(BadmintonApplication.class, "src/test/resources/configuration-test.yml");

    @Test
    public void best_should_return_Lin_Dan() {
        JerseyClient client = new JerseyClientBuilder().build();

        Player player = client.target("http://localhost:8080/players/best")
                .request()
                .get(Player.class);

        assertThat(player.getName()).isEqualTo("Lin Dan");
    }
}
