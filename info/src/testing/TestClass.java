package testing;

import java.util.ArrayList;
import java.util.HashMap;

import michaelzhang.databaseinformation.DatabaseInformation;
import michaelzhang.fileinteraction.CSVContents;
import michaelzhang.fileinteraction.DataContent;
import michaelzhang.formatter.UserDataFormatter;
import michaelzhang.tableinteraction.SQLFormattedRecords;
import michaelzhang.tablesinformation.TableInformation;
import michaelzhang.user.UserPreferences;

public class TestClass {
	public static void print1dArray(String[] a) {
		System.out.println("");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("");
	}
	
	public static void print2dArray(String[][] a) {
		System.out.println("");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		// preliminary set up (information is retrieved via user interaction with GUI)
		UserPreferences prefs = new UserPreferences();
		
//		DatabaseInformation dbInfo = new DatabaseInformation(databaseURL, jdbcDriver, username, password, databaseType);
//		prefs.setDatabaseInformation(dbInfo);
		DatabaseInformation dbInfo = new DatabaseInformation(); //
		prefs.setDatabaseInformation(dbInfo); //
		prefs.setDatabaseType("oRaClE"); //
		
//		TableCollection tc = new TableCollection(conn, databaseName, prefs);
//		prefs.setTableCollection(tc);
//		prefs.setTableInformation(prefs.getTableCollection().getTable(id)); // id is the same as table name by default, unless changed
		String tableName = "TESTING_TABLE"; //
		String[] columnNameOrder = new String[] {"COLUMN_1", "COLUMN_2", "COLUMN_3", "COLUMN_4", "COLUMN_5"}; //
		String[] columnDataOrder = new String[] {"VARCHAR", "VARCHAR", "DATE", "NUMBER", "NUMBER"}; //
		TableInformation t = new TableInformation(tableName, columnNameOrder, columnDataOrder); //
		prefs.setTableInformation(t); //
		
		String loc = "testingdocuments/testingdocument.csv"; //
		boolean hasHeader = true; //
		String[] userOrder = new String[] {"COLUMN_2", "COLUMN_5", "COLUMN_3"}; //
		prefs.setFileLocation(loc);
		prefs.setHeaderStatus(hasHeader);
		prefs.setColumnOrdering(userOrder);
		
		
		
		// process data and insert records
		String fileLocation = prefs.getFileLocation();
		System.out.println("\n\nFile location: " + fileLocation); //
		CSVContents csvContents = new CSVContents(fileLocation);
		ArrayList<String[]> allContents = csvContents.getAllRows();
		System.out.println("\n\nCSV contents:"); //
		TestClass.print2dArray(UserDataFormatter.twoDimArray(allContents)); //
		
		boolean header = prefs.getHeaderStatus();
		System.out.println("\n\nHeader status: " + header); //
		String[] userOrdering = prefs.getColumnOrdering();
		System.out.println("\n\nUser ordered data (as entered in by user):"); //
		TestClass.print1dArray(userOrdering); //
		HashMap<String,String> tableColumnOrdering = prefs.getTableInformation().getColumnOrder();
		System.out.println("\nTable columns: " + tableColumnOrdering.keySet()); //
		DataContent records = new DataContent(header, allContents, userOrdering, tableColumnOrdering);
		String[][] tableFormattedData = records.getTableFormattedData();
		System.out.println("\n\nFormatted data (to fit table):");
		TestClass.print2dArray(tableFormattedData); //
		
		String databaseType = prefs.getDatabaseType();
		System.out.println("\n\nDatabase type: " + databaseType); //
		TableInformation table = prefs.getTableInformation();
		SQLFormattedRecords sqlData = new SQLFormattedRecords(databaseType, table, tableFormattedData);
		String[] insertionStrings = sqlData.getInsertRecordStrings();
		System.out.println("\n\nFormatted data (to be inserted into table:");
		TestClass.print1dArray(insertionStrings); //
		
		System.out.println("\n\nDone!");
//		boolean success = InsertUserRecords.insertRecords(prefs, insertionStrings);
//		if (success) System.out.println("Successfully inserted all records!");
//		else System.out.println("Error. Some records successfully inserted.");
	}
}
