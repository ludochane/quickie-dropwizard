package dao;

import io.dropwizard.hibernate.AbstractDAO;
import model.Player;
import org.hibernate.SessionFactory;

/**
 * User: ludochane
 */
public class PlayerDao extends AbstractDAO<Player> {
    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public PlayerDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Player findBest() {
        return this.get(1L);
    }

    public Long create(Player player) {
        return persist(player).getId();
    }
}
