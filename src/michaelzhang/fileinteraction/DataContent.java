package michaelzhang.fileinteraction;

import michaelzhang.user.UserPreferences;
import michaelzhang.formatter.UserDataFormatter;
import java.util.ArrayList;

/**
 * Takes the entire content of an ArrayList<String[]> and stores it according to an appropriate format.
 * The appropriate format is according to the table that is being interacted with. The appropriate
 * format will match the column ordering of the table and will shear the first row if the first row is
 * comprised of a header and not actual data. Note, for every record that has an empty column entry, null
 * will be stored at that column entry's index.
 * @author Michael Zhang
 * 
 */
public class DataContent {
	/* All of the records from the .csv file in correct table ordering. Empty values are null. */
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
		this.deleteHeader(prefs, rows); // deletes any extraneous first row
		rows = UserDataFormatter.deleteEmptyColumns(rows, ""); // deletes any empty columns of the .csv file (assuming "" means a column is empty)
		this.TABLE_FORMATTED_DATA = UserDataFormatter.fitDataToTable(prefs, rows);
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
	 * Empty values within a record are represented as null.
	 * @return	the formatted data according to a table
	 */
	public String[][] getTableFormattedData() {
		return this.TABLE_FORMATTED_DATA;
	}	
}
