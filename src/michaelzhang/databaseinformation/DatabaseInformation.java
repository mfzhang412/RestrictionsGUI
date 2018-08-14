package michaelzhang.databaseinformation;

/**
 * Contains information on the overview of a database.
 * The contained information includes the database URL, the JDBC driver name, the
 * user name and password for the database, and the database type (Oracle, PostgreSQL,
 * MySQL, etc).
 * @author michael.zhang
 *
 */
public class DatabaseInformation {
	/* The database URL */
	private String databaseURL;
	/* The JDBC driver name */
	private String jdbcDriver;
	/* The database user name */
	private String username;
	/* The database password */
	private String password;
	/* The database type in UPPERCASE(Oracle, PostgreSQL, MySQL, etc) */
	private String databaseType;
	
	/**
	 * Create a DatabaseInformation object that contains the database URL, JDBC driver name,
	 * database user name, database password, and database type (Oracle, PostgreSQL, MySQL, etc).
	 * @param databaseURL	the database URL
	 * @param jdbcDriver	the JDBC driver name
	 * @param username		the database user name
	 * @param password		the database password
	 * @param databaseType	the database type (Oracle, PostgreSQL, MySQL, etc)
	 */
	public DatabaseInformation(String databaseURL, String jdbcDriver, String username, String password, String databaseType) {
		this.setDatabaseURL(databaseURL);
		this.setJDBCDriver(jdbcDriver);
		this.setUsername(username);
		this.setPassword(password);
		this.setDatabaseType(databaseType);
	}
	
	/**
	 * Return the database URL.
	 * @return the database URL
	 */
	public String getDatabaseURL() {
		return databaseURL;
	}
	
	/**
	 * Set the database URL.
	 * @param databaseURL the database URL
	 */
	public void setDatabaseURL(String databaseURL) {
		this.databaseURL = databaseURL;
	}
	
	/**
	 * Return the JDBC driver name.
	 * @return the JDBC driver name
	 */
	public String getJDBCDriver() {
		return jdbcDriver;
	}
	
	/**
	 * Set the JDBC driver name.
	 * @param jdbcDriver the JDBC driver name
	 */
	public void setJDBCDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}
	
	/**
	 * Return the database user name.
	 * @return the database user name
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Set the database user name.
	 * @param username the database user name
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Return the database password.
	 * @return the database password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Set the database password.
	 * @param password the database password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Return the database type (MySQL, PostgreSQL, Oracle, etc).
	 * @return the database type (MySQL, PostgreSQL, Oracle, etc)
	 */
	public String getDatabaseType() {
		return databaseType;
	}
	
	/**
	 * Set the database type (MySQL, PostgreSQL, Oracle, etc).
	 * @param databaseType the database type (MySQL, PostgreSQL, Oracle, etc)
	 */
	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}
}
