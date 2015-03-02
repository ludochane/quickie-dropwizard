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
public class BadmintonApplication extends io.dropwizard.Application<BadmintonConfiguration> {

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
        environment.jersey().register(new PlayerResource());

        environment.healthChecks().register("Database HealtCheck", new DatabaseHealthCheck());
    }
}
