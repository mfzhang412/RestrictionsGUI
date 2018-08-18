package michaelzhang.fileinteraction;

import java.util.ArrayList;
import java.util.HashMap;

import michaelzhang.formatter.UserDataFormatter;

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
	/* All of the records from the .csv file in correct table ordering. Empty values are null */
	final private String[][] TABLE_FORMATTED_DATA;
	
	/**
	 * Format an ArrayList<String[]> object according to its corresponding table.
	 * Take an ArrayList<String[]> representation of the rows in a .csv file, shear the
	 * first row if there is a header, formats the actual data according to its
	 * corresponding table (from UserPreferences) and saves it as an instance variable.
	 * @param header				true if there is a header to be deleted (first row), false otherwise
	 * @param rows					all the unmodified rows of a .csv file
	 * @param userColumnOrdering	the order of the entered in data by the user
	 * @param tableColumnOrder		map of table column names in order
	 */
	public DataContent(boolean header, ArrayList<String[]> rows,
			String[] userColumnOrdering, HashMap<String,String> tableColumnOrder) {
		this.deleteHeader(header, rows); // deletes any extraneous first row
		rows = UserDataFormatter.deleteEmptyColumns(rows, ""); // deletes any empty columns of the .csv file (assuming "" means a column is empty)
		this.TABLE_FORMATTED_DATA = UserDataFormatter.fitDataToTable(userColumnOrdering, tableColumnOrder, rows);
	}
	
	/**
	 * Delete the first entry of an ArrayList<String[]> if it's a header row (contains no meaningful data).
	 * Deletion occurs based upon UserPreferences: if the UserPreferences object has specified that
	 * the first row is a header row. Returns true if the first entry of the ArrayList<String[]> has been
	 * sheared off, false otherwise.
	 * @param header	true if there is a header to be deleted (first row), false otherwise
	 * @param rows		all the unmodified rows of a .csv file
	 * @return	whether the first row has been deleted
	 */
	private boolean deleteHeader(boolean header, ArrayList<String[]> rows) {
		if (header) { // checks to see if .csv file has a header(true), false otherwise
			rows.remove(0); // removes first index of the arrayList (corresponds to .csv column headers)
			return true;
		}
		return false; // returns false if nothing was removed
	}
	
	/**
	 * Return the formatted data where each index within a record corresponds to the table's column.
	 * Empty values within a record are represented as null.
	 * @return	the formatted data according to a table
	 */
	public String[][] getTableFormattedData() {
		return this.TABLE_FORMATTED_DATA;
	}
}
