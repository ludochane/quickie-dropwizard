package resource;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import dao.PlayerDao;
import io.dropwizard.hibernate.UnitOfWork;
import model.Player;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * User: ludochane
 */
@Path("/players")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/players", description = "Operations sur les Joueurs")
public class PlayerResource {

    private PlayerDao playerDao;

    public PlayerResource(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    @GET
    @Path("/best")
    @UnitOfWork
    @ApiOperation("Retourne le meilleur joueur")
    public Player best() {
        return this.playerDao.findBest();
    }

    @POST
    @Path("/new")
    @UnitOfWork
    @ApiOperation("Crée un nouveau joueur")
    public Player create(@QueryParam("name") String name) {
        Player player = new Player(name);
        this.playerDao.create(player);
        return player;
    }
}
