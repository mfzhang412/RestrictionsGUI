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
	/* The database URL. */
	private String databaseURL;
	/* The JDBC driver name. */
	private String jdbcDriver;
	/* The database user name. */
	private String username;
	/* The database password. */
	private String password;
	/* The database type in UPPERCASE(Oracle, PostgreSQL, MySQL, etc). */
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
	 * @return the databaseURL
	 */
	public String getDatabaseURL() {
		return databaseURL;
	}
	
	/**
	 * @param databaseURL the databaseURL to set
	 */
	public void setDatabaseURL(String databaseURL) {
		this.databaseURL = databaseURL;
	}
	
	/**
	 * @return the jdbcDriver
	 */
	public String getJDBCDriver() {
		return jdbcDriver;
	}
	
	/**
	 * @param jdbcDriver the jdbcDriver to set
	 */
	public void setJDBCDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the databaseType
	 */
	public String getDatabaseType() {
		return databaseType;
	}
	
	/**
	 * @param databaseType the databaseType to set
	 */
	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}
}
