import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

/**
 * User: ludochane
 */
@Path("/players")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {

    @GET
    public List<Player> best() {
        // TODO
    }
}
