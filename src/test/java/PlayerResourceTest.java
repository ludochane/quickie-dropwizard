import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * User: ludochane
 */
public class PlayerResourceTest {

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PlayerResource())
            .build();

    @Test
    public void best_should_return_Lin_Dan() {
        Client client = resources.client();

        Player player = client.target("http://localhost:8080/players/best").request().get(Player.class);

        assertThat(player.getName()).isEqualTo("Lin Dan");
    }
}
