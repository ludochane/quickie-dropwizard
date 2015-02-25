import com.codahale.metrics.health.HealthCheck;

/**
 * User: ludochane
 */
public class DatabaseHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.unhealthy("Connexion perdue");
    }
}
