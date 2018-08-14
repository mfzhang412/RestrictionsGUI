package michaelzhang.user;

import michaelzhang.databaseinformation.DatabaseInformation;
import michaelzhang.tablesinformation.TableCollection;
import michaelzhang.tablesinformation.TableInformation;

/**
 * Dummy object to store all of the user preferences so as to allow for easier data acquisition by other classes.
 * The user's selections will be stored here and then passed on to different classes that will then
 * call getter and setter methods. When UserPreferences object is created, it has the following
 * default values: headerStatus = false.
 * @author michael.zhang
 *
 */
public class UserPreferences {
	/* Whether the .txt or .csv document has an extraneous header: true, false otherwise */
	private boolean headerStatus;
	/* The order of the user's entered data */
	private String[] userColumnOrdering;
	/* The table being interacted with */
	private TableInformation table;
	/* The tables in the database */
	private TableCollection tableCollection;
	/* The database's information */
	private DatabaseInformation dbInfo;
	/* The file path of the .txt or .csv document */
	private String fileLocation;
	
	/**
	 * Create a new UserPreferences object and set the headerStatus to the default of false.
	 */
	public UserPreferences() {
		this.setHeaderStatus(false);
	}
	
	/**
	 * Return whether the .csv or .txt file has a header that must be sheared off.
	 * True is that an extraneous header (first row) is present, false otherwise.
	 * @return	true if the first row of .csv or .txt is extraneous, false otherwise.
	 */
	public boolean getHeaderStatus() {
		return this.headerStatus;
	}
	
	/**
	 * Set the status of whether there is an extraneous first row of the .csv or .txt file.
	 * True is that an extraneous header (first row) is present, false otherwise.
	 * @param b	the boolean to be set
	 */
	public void setHeaderStatus(boolean b) {
		this.headerStatus = b;
	}
	
	/**
	 * Return the column ordering as entered in by the user.
	 * @return	the column ordering as entered in by the user
	 */
	public String[] getColumnOrdering() {
		return this.userColumnOrdering;
	}
	
	/**
	 * Set the column ordering as entered in by the user.
	 * The passed in method should contain the table column names in the order that the data
	 * was entered in the .csv or .txt file. For example, if the user enters names in the first
	 * column and birthdays in the third column, then the passed in String[] array should have
	 * ["NAME", "","BIRTHDAY"].
	 * @param userOrder
	 */
	public void setColumnOrdering(String[] userOrder) {
		this.userColumnOrdering = userOrder;
	}
	
	/**
	 * Return the table being interacted with.
	 * @return	the table being interacted with
	 */
	public TableInformation getTableInformation() {
		return this.table;
	}
	
	/**
	 * Set the table being interacted with.
	 * @param table	the table being interacted with
	 */
	public void setTableInformation(TableInformation table) {
		this.table = table;
	}
	
	/**
	 * Return the tables in the database.
	 * @return	the tables in the database
	 */
	public TableCollection getTableCollection() {
		return this.tableCollection;
	}
	
	/**
	 * Set the tables in the database.
	 * @param tables	the tables in the database
	 */
	public void setTableCollection(TableCollection tables) {
		this.tableCollection = tables;
	}
	
	/**
	 * Return the database type (MySQL, PostgreSQL, Oracle, etc).
	 * @return	the database type
	 */
	public String getDatabaseType() {
		return this.dbInfo.getDatabaseType();
	}
	
	/**
	 * Set the database type (MySQL, PostgreSQL, Oracle, etc).
	 * @param type	the database type
	 */
	public void setDatabaseType(String type) {
		this.dbInfo.setDatabaseType(type.toUpperCase());
	}
	
	/**
	 * Return the driver name.
	 * @return	the driver name
	 */
	public String getJDBCDriver() {
		return this.dbInfo.getJDBCDriver();
	}
	
	/**
	 * Set the driver name.
	 * @param driver	the driver name
	 */
	public void setJDBCDriver(String driver) {
		this.dbInfo.setJDBCDriver(driver);
	}
	
	/**
	 * Return the database URL.
	 * @return	the database URL
	 */
	public String getDatabaseURL() {
		return this.dbInfo.getDatabaseURL();
	}
	
	/**
	 * Set the database URL.
	 * @param url	the database URL
	 */
	public void setDatabaseURL(String url) {
		this.dbInfo.setDatabaseURL(url);
	}
	
	/**
	 * Return the database user name.
	 * @return	the database user name
	 */
	public String getUsername() {
		return this.dbInfo.getUsername();
	}
	
	/**
	 * Set the database user name.
	 * @param user	the database user name
	 */
	public void setUsername(String user) {
		this.dbInfo.setUsername(user);
	}
	
	/**
	 * Return the database password.
	 * @return
	 */
	public String getPassword() {
		return this.dbInfo.getPassword();
	}
	
	/**
	 * Set the database password.
	 * @param pass	the database password
	 */
	public void setPassword(String pass) {
		this.dbInfo.setPassword(pass);
	}
	
	/**
	 * Return the location of the .txt or .csv file.
	 * @return	the location of the .txt or .csv file
	 */
	public String getFileLocation() {
		return this.fileLocation;
	}
	
	/**
	 * Set the location of the .txt or .csv file.
	 * @param loc	the location of the .txt or .csv file
	 */
	public void setFileLocation(String loc) {
		this.fileLocation = loc;
	}
	
	/**
	 * Return the database information.
	 * @return	the database information
	 */
	public DatabaseInformation getDatabaseInformation() {
		return dbInfo;
	}
	
	/**
	 * Set the database information.
	 * @param dbInfo	the database information
	 */
	public void setDatabaseInformation(DatabaseInformation dbInfo) {
		this.dbInfo = dbInfo;
	}
}
