package michaelzhang.user;

import michaelzhang.tablesinformation.*;

/**
 * Dummy object to store all of the user preferences so as to allow for easier data acquisition by other classes.
 * The user's selections will be stored here and then passed on to different classes that will then
 * call getter and setter methods. When UserPreferences object is created, it has the following
 * default values: headerStatus = false.
 * @author michael.zhang
 *
 */
public class UserPreferences {
	private boolean headerStatus; // doesthecsvfilehaveafirstlineheaderorisitarecordtobeentered
	private String[] userColumnOrdering; // whichcolumncorrespondstowhatdataenteredinbyuserbasicallywhatorderarethecolumns; //stores column ordering
	private TableInformation table; // tablebeinginteractedwith
	private TableCollection tableCollection;
	private String databaseType; // Oracle, PostgreSQL, MySQL, etc.
	
	/**
	 * Creates a new UserPreferences object and sets the headerStatus to the default of false.
	 */
	public UserPreferences() {
		this.setHeaderStatus(false);
	}
	
	/**
	 * Returns whether the .csv or .txt file has a header that must be sheared off.
	 * True is that an extraneous header (first row) is present, false otherwise.
	 * @return	true if the first row of .csv or .txt is extraneous, false otherwise.
	 */
	public boolean getHeaderStatus() {
		return this.headerStatus;
	}
	
	/**
	 * Sets the status of whether there is an extraneous first row of the .csv or .txt file.
	 * True is that an extraneous header (first row) is present, false otherwise.
	 * @param b	the boolean to be set
	 */
	public void setHeaderStatus(boolean b) {
		this.headerStatus = b;
	}
	
	/**
	 * Sets the column ordering as entered in by the user.
	 * The passed in method should contain the table column names in the order that the data
	 * was entered in the .csv or .txt file. For example, if the user enters names in the first
	 * column and birthdays in the third column, then the passed in String[] array should have
	 * ["NAME", "","BIRTHDAY"].
	 * @param userOrder
	 */
	public void setColumnOrdering(String[] userOrder) {
		this.userColumnOrdering = userOrder;
	}
	
	public String[] getColumnOrdering() {
		return this.userColumnOrdering;
	}
	
	public void setTableInformation(TableInformation t) {
		this.table = t;
	}
	
	public TableInformation getTableInformation() {
		return this.table;
	}

	public void setTableCollection(TableCollection c) {
		this.tableCollection = c;
	}
	
	public TableCollection getTableCollection() {
		return this.tableCollection;
	}
	
	public void setDatabaseType(String type) {
		this.databaseType = type;
	}
	
	public String getDatabaseType() {
		return this.databaseType;
	}
}
