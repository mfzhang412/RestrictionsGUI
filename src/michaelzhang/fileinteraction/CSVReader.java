package michaelzhang.fileinteraction;

import michaelzhang.user.UserPreferences;
import michaelzhang.formatter.UserDataFormatter;
import java.util.ArrayList;

/*
 * stores the csv file's contents in an appropriate format.
 * Make sure they conform to the datatypes listed in TableRecords.
 */
public class CSVReader {
	private String[][] modRecords; /* an array or records from the csv file.
									  Note that it reflects the ordering found in TablesInformation.
									  Empty table values are going to be represented by "". */
	/**
	 * Stores the rows of the .cvs file in an appropriate format for later use.
	 * Appropriate format is dependent on the table's column order and the data types.
	 * If the user preference excludes a column's data, the placeholder will be "".
	 * @param prefs			user preferences
	 * @param csvAllRows	all of the rows from the .cvs file
	 */
	public CSVReader(UserPreferences prefs, ArrayList<String[]> csvAllRows) {
		boolean headers = prefs.getHeaderStatus(); // checks to see if .csv file has a header (true)
		if (headers) {
			csvAllRows.remove(0); // removes first index of the arrayList (corresponds to .csv column headers)
		}
		ArrayList<String[]> dataTypedList = UserDataFormatter.modDataTypes(prefs, csvAllRows); // modifies record values to reflect data type
		ArrayList<String[]> orderedList = UserDataFormatter.orderList(prefs, dataTypedList); // modifies arrayList so that the data is in the correct table ordering
		this.modRecords = this.toArray(orderedList);
	}
	/**
	 * Returns a String[][] array of an ArrayList<String[]>.
	 * @param toArray	the ArrayList to be a String[][] array
	 * @return			the String[][] array of the ArrayList
	 */
	private String[][] toArray(ArrayList<String[]> toArray) {
		return toArray.toArray(new String[toArray.size()][toArray.get(0).length]);
	}
	/**
	 * Returns the modified records.
	 * The modified records: (1) the index of each record corresponds to the ordered table column.
	 * 						 (2) the entries of each record has the correct formatting to be
	 * 							 directly inserted to a SQL String statement
	 * @return	correctly formatted .cvs records
	 */
	public String[][] getModRecords() {
		return this.modRecords;
	}
}
