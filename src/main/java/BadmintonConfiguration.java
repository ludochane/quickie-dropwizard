import io.dropwizard.Configuration;

/**
 * User: ludochane
 */
public class BadmintonConfiguration extends io.dropwizard.Configuration {

    private String jdbcDriver;

    private String jdbcUser;

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcUser() {
        return jdbcUser;
    }

    public void setJdbcUser(String jdbcUser) {
        this.jdbcUser = jdbcUser;
    }
}
