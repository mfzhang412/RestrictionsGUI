package michaelzhang.user;

import michaelzhang.tablesinformation.*;
/*
 * stores the things entered in the GUI.
 */
public class UserPreferences {
	boolean doesthecsvfilehaveafirstlineheaderorisitarecordtobeentered;
	String[] whichcolumncorrespondstowhatdataenteredinbyuserbasicallywhatorderarethecolumns; //stores column ordering
	TableInformation tablebeinginteractedwith;
	String databasenamethattheuserisinteractingwith; // or the actual database connection
	TableCollection thecollectionoftablesforthedatabase;
	
	public boolean getHeaderStatus() {
		return this.doesthecsvfilehaveafirstlineheaderorisitarecordtobeentered;
	}
	
	public String[] getColumnOrdering() {
		return this.whichcolumncorrespondstowhatdataenteredinbyuserbasicallywhatorderarethecolumns;
	}
	
	public TableInformation getTableInformation() {
		return this.tablebeinginteractedwith;
	}
	
	public String getDatabaseName() {
		return this.databasenamethattheuserisinteractingwith; // or the actual database connection
	}
	
	public TableCollection getTableCollection() {
		return this.thecollectionoftablesforthedatabase;
	}
}
