import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * User: ludochane
 */
public class BadmintonApplication extends io.dropwizard.Application<BadmintonConfiguration> {

    public static void main(String[] args) throws Exception {
        new BadmintonApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<BadmintonConfiguration> bootstrap) {

    }

    @Override
    public void run(BadmintonConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new PlayerResource());

        environment.healthChecks().register("Database HealtCheck", new DatabaseHealthCheck());
    }
}
