package michaelzhang.graphicalinterface;

import java.util.ArrayList;
import java.util.HashMap;

import michaelzhang.databaseinformation.DatabaseInformation;
import michaelzhang.fileinteraction.CSVContents;
import michaelzhang.fileinteraction.DataContent;
import michaelzhang.tableinteraction.InsertUserRecords;
import michaelzhang.tableinteraction.SQLFormattedRecords;
import michaelzhang.tablesinformation.TableCollection;
import michaelzhang.tablesinformation.TableInformation;
import michaelzhang.user.UserPreferences;

/*
 * displays the interface that the user will be working with.
 * Will have a select document for the .csv location, a table selector
 * for the table to do things with the record,
 * a column selector that will tell which column in the .csv corresponds to what data,
 * a task number input dialogue, whether they want to delete, update, or insert records.
 */
public class GraphicalUserInterface {
	
	/**
	 * Main method.
	 * @param args	arguments
	 */
	public static void main(String[] args) {
		UserPreferences prefs = new UserPreferences();
		
		
		DatabaseInformation dbInfo = new DatabaseInformation(databaseURL, jdbcDriver, username, password, databaseType);
		prefs.setDatabaseInformation(dbInfo);
		
		TableCollection tc = new TableCollection(conn, databaseName, prefs);
		prefs.setTableCollection(tc);
		prefs.setTableInformation(prefs.getTableCollection().getTable(id));
		
		prefs.setFileLocation(loc);
		prefs.setHeaderStatus(b);
		prefs.setColumnOrdering(userOrder);
		
		
		
		String fileLocation = prefs.getFileLocation();
		CSVContents csvContents = new CSVContents(fileLocation);
		ArrayList<String[]> allContents = csvContents.getAllRows();
		
		boolean header = prefs.getHeaderStatus();
		String[] userOrdering = prefs.getColumnOrdering();
		HashMap<String,String> tableColumnOrdering = prefs.getTableInformation().getColumnOrder();
		DataContent records = new DataContent(header, allContents, userOrdering, tableColumnOrdering);
		String[][] tableFormattedData = records.getTableFormattedData();
		
		String databaseType = prefs.getDatabaseType();
		TableInformation table = prefs.getTableInformation();
		SQLFormattedRecords sqlData = new SQLFormattedRecords(databaseType, table, tableFormattedData);
		String[] insertionStrings = sqlData.getInsertRecordStrings();
		
		boolean success = InsertUserRecords.insertRecords(prefs, insertionStrings);
		if (success) System.out.println("Successfully inserted all records!");
		else System.out.println("Error. Some records successfully inserted.");
	}
}














































