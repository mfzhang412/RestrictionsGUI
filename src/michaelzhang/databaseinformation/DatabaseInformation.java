package michaelzhang.databaseinformation;

public class DatabaseInformation {
	private String databaseURL; // database URL
	private String jdbcDriver; // driver name
	private String username; // database username credential
	private String password; // database password credential
	private String databaseType; // Oracle, PostgreSQL, MySQL, etc. (in upper case)
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
