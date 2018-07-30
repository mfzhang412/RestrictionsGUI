package michaelzhang.graphicalinterface;

import michaelzhang.fileinteraction.*;
import michaelzhang.tableinteraction.*;
import michaelzhang.tablesinformation.*;
import michaelzhang.user.*;
import java.util.ArrayList;
import java.util.HashMap;

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
		//prefs.set(); // set everything (consider making a builder class for UserPreferences)
		
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
