import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * User: ludochane
 */
@Path("/players")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {

    @GET
    @Path("/best")
    @Timed
    public Player best() {
        return new Player("Lin Dan");
    }
}
