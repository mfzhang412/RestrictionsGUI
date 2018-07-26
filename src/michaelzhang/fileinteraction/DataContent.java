package michaelzhang.fileinteraction;

import michaelzhang.user.UserPreferences;
import java.util.ArrayList;

/**
 * Takes the entire content of an ArrayList<String[]> and stores it according to an appropriate format.
 * The appropriate format is according to the table that is being interacted with. The appropriate
 * format will match the column ordering of the table and will shear the first row if the first row is
 * comprised of a header and not actual data. Note, for every record that has an empty column entry, ""
 * will be stored at that column entry's index.
 * @author Michael Zhang
 * 
 */
public class DataContent {
	/* All of the records from the .csv file in correct table ordering. Empty values are "". */
	final private String[][] TABLE_FORMATTED_DATA;
	
	/**
	 * Formats an ArrayList<String[]> object according to its corresponding table.
	 * Take an ArrayList<String[]> representation of the rows in a .csv file, shears the
	 * first row if UserPreferences says it's just a row of column headers, formats the
	 * actual data according to its corresponding table (from UserPreferences) and saves it
	 * as an instance variable.
	 * @param prefs	the preferences specified by a user
	 * @param rows	all the unmodified rows of a .csv file
	 */
	public DataContent(UserPreferences prefs, ArrayList<String[]> rows) {
		this.deleteHeader(prefs, rows);
		// do: takes rows and format them correctly according to description and TableInformation from prefs,
			// save it to modRows variable. Maybe use a key or map to accomplish this?
		
		this.TABLE_FORMATTED_DATA = modRows;
	}
	
	/**
	 * Deletes the first entry of an ArrayList<String[]> if it's a header row (contains no meaningful data).
	 * Deletion occurs based upon UserPreferences: if the UserPreferences object has specified that
	 * the first row is a header row. Returns true if the first entry of the ArrayList<String[]> has been
	 * sheared off, false otherwise.
	 * @param prefs	the preferences specified by a user
	 * @param rows	all the unmodified rows of a .csv file
	 * @return	whether the first row has been deleted
	 */
	private boolean deleteHeader(UserPreferences prefs, ArrayList<String[]> rows) {
		boolean header = prefs.getHeaderStatus(); // checks to see if .csv file has a header(true), false otherwise
		if (header) {
			rows.remove(0); // removes first index of the arrayList (corresponds to .csv column headers)
			return true;
		}
		return false; // returns false if nothing was removed
	}
	
	/**
	 * Returns the formatted data where each index within a record corresponds to the table's column.
	 * Empty values within a record are represented as an empty string "".
	 * @return	the formatted data according to a table
	 */
	public String[][] tableFormattedData() {
		return this.TABLE_FORMATTED_DATA;
	}
	
	

//	/**
//	 * Stores the rows of the .csv file in an appropriate format for later use.
//	 * Appropriate format is dependent on the table's column order and the data types.
//	 * If the user preference excludes a column's data, the placeholder will be "".
//	 * @param prefs			user preferences
//	 * @param csvAllRows	all of the rows from the .cvs file
//	 */
//	public CSVReader(UserPreferences prefs, ArrayList<String[]> csvAllRows) {
//		boolean headers = prefs.getHeaderStatus(); // checks to see if .csv file has a header (true)
//		if (headers) {
//			csvAllRows.remove(0); // removes first index of the arrayList (corresponds to .csv column headers)
//		}
//		ArrayList<String[]> dataTypedList = UserDataFormatter.modDataTypes(prefs, csvAllRows); // modifies record values to reflect data type
//		ArrayList<String[]> orderedList = UserDataFormatter.orderList(prefs, dataTypedList); // modifies arrayList so that the data is in the correct table ordering
//		this.modRecords = this.toArray(orderedList);
//	}
//	/**
//	 * Returns a String[][] array of an ArrayList<String[]>.
//	 * @param toArray	the ArrayList to be a String[][] array
//	 * @return			the String[][] array of the ArrayList
//	 */
//	private String[][] toArray(ArrayList<String[]> toArray) {
//		return toArray.toArray(new String[toArray.size()][toArray.get(0).length]);
//	}
//	/**
//	 * Returns the modified records.
//	 * The modified records: (1) the index of each record corresponds to the ordered table column.
//	 * 						 (2) the entries of each record has the correct formatting to be
//	 * 							 directly inserted to a SQL String statement
//	 * @return	correctly formatted .cvs records
//	 */
//	public String[][] getModRecords() {
//		return this.modRecords;
//	}
	
	
	
}
