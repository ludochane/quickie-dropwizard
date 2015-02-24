import dao.PlayerDao;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerDropwizard;
import model.Player;
import resource.PlayerResource;

/**
 * User: ludochane
 */
public class BadmintonApplication extends Application<BadmintonConfiguration> {

    private final HibernateBundle<BadmintonConfiguration> hibernateBundle = new HibernateBundle<BadmintonConfiguration>(Player.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(BadmintonConfiguration badmintonConfiguration) {
            return badmintonConfiguration.getDatabase();
        }
    };

    private final MigrationsBundle<BadmintonConfiguration> migrationsBundle = new MigrationsBundle<BadmintonConfiguration>() {
        @Override
        public DataSourceFactory getDataSourceFactory(BadmintonConfiguration badmintonConfiguration) {
            return badmintonConfiguration.getDatabase();
        }
    };

    private final SwaggerDropwizard swaggerDropwizard = new SwaggerDropwizard();

    public static void main(String[] args) throws Exception {
        new BadmintonApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<BadmintonConfiguration> bootstrap) {
        // bundle
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(migrationsBundle);
        swaggerDropwizard.onInitialize(bootstrap);
    }

    @Override
    public void run(BadmintonConfiguration configuration, Environment environment) throws Exception {
        // dao
        PlayerDao playerDao = new PlayerDao(hibernateBundle.getSessionFactory());

        // jersey
        environment.jersey().register(new PlayerResource(playerDao));

        // swagger
        swaggerDropwizard.onRun(configuration, environment, "localhost", 8080);

    }
}
