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

/**
 * Displays the interface that the user will be interacting with.
 * This class also serves as the entry point for the application.
 * @author michael.zhang
 *
 */
public class GraphicalUserInterface {
	
	/**
	 * Entry point for the application.
	 * @param args	arguments
	 */
	public static void main(String[] args) {
		// preliminary set up (information is retrieved via user interaction with GUI)
		UserPreferences prefs = new UserPreferences();
		
		DatabaseInformation dbInfo = new DatabaseInformation(databaseURL, jdbcDriver, username, password, databaseType);
		prefs.setDatabaseInformation(dbInfo);
		
		TableCollection tc = new TableCollection(conn, databaseName, prefs);
		prefs.setTableCollection(tc);
		prefs.setTableInformation(prefs.getTableCollection().getTable(id)); // id is the same as table name by default, unless changed
		
		prefs.setFileLocation(loc);
		prefs.setHeaderStatus(hasHeader);
		prefs.setColumnOrdering(userOrder);
		
		
		// process data and insert records
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














































