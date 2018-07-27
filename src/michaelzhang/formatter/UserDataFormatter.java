package michaelzhang.formatter;

import michaelzhang.user.UserPreferences;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/**
 * This class acts as a logic container for formatting incoming user data to fit a table in a database.
 * @author michael.zhang
 *
 */
public class UserDataFormatter {
	
	/**
	 * Transposes a 2D String[][] array and returns it.
	 * @param matrix	the 2D String[][] to be transposed
	 * @return	the transposed String[][] array
	 */
	public static String[][] transpose(String[][] matrix) {
		int m = matrix.length;
	    int n = matrix[0].length;
	    String[][] trasposedMatrix = new String[n][m];
	    for (int x = 0; x < n; x++) {
	        for (int y = 0; y < m; y++) {
	            trasposedMatrix[x][y] = matrix[y][x];
	        }
	    }
	    return trasposedMatrix;
	}
	
	/**
	 * Transposes an ArrayList<String[]> while preserving the ArrayList<String[]> structure and returns it.
	 * @param matrix	the ArrayList<String[]> to be transposed
	 * @return	the transposed ArrayList<String[]> object
	 */
	public static ArrayList<String[]> transposeArrayList(ArrayList<String[]> matrix) {
		return UserDataFormatter.twoDimArrayList(UserDataFormatter.transpose(UserDataFormatter.twoDimArray(matrix)));
	}
	
	/**
	 * Returns an ArrayList<String[]> where the String[] arrays that are completely filled with the emptyValue parameter are removed.
	 * @param rows			the rows to be stripped of empty columns
	 * @param emptyValue	the String value to check for
	 * @return	an ArrayList<String[]> where filled emptyValue columns of the String[] array are removed
	 */
	public static ArrayList<String[]> deleteEmptyColumns(ArrayList<String[]> rows, String emptyValue) {
		ArrayList<String[]> tempTranspose = UserDataFormatter.transposeArrayList(rows); // transpose data parameter into an ArrayList<String[]> structure
		for (int i = tempTranspose.size() - 1; i >= 0; i--) {
			if (UserDataFormatter.isFullOf(tempTranspose.get(i), emptyValue)) { // check to see if a column is filled with "".
				tempTranspose.remove(i);
			}
		}
		return UserDataFormatter.transposeArrayList(tempTranspose); // transpose it back to an ArrayList<String[]>
	}
	
	/**
	 * Checks to see if the passed in String[] array is filled with the String
	 * Returns true if the array is filled with the string, false otherwise.
	 * @param str	the string
	 * @return	true if array is filled with the string, false otherwise
	 */
	public static boolean isFullOf(String[] a, String str) {
		for (int i = 0; i < a.length; i++) {
			if (!a[i].equals(str)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Adjusts data to fit the column data types of the respective table.
	 * Takes in the user entered in data and formats the data to return a String[][] array
	 * or all the records correctly. The String[][] array will have records and their respective
	 * values in the order presented in the table. Values that are empty are represented by null.
	 * Note this method does not modify the data types of the input data, it only rearranges the
	 * data and adds columns where values were not entered by the user.
	 * @param prefs	UserPreferences object to obtain the table specifications
	 * @param rows	the data to be fit to the table format
	 * @return
	 */
	public static String[][] fitDataToTable(UserPreferences prefs, ArrayList<String[]> rows) {
		String[][] matrix = UserDataFormatter.twoDimArray(rows); // converts rows to String[][]
		String[][] transposedRows = UserDataFormatter.transpose(matrix); // transposes String[][]
		
		Map<String,String> hash = prefs.getTableInformation().getColumnOrder(); // creates mapping of table column names in order
		Iterator<String> iter = hash.keySet().iterator(); // creates iterator to go through the mapping
		
		ArrayList<String[]> transModRows = new ArrayList<String[]>(); // the ArrayList to be returned modified
		
		String[] userColumnOrdering = prefs.getColumnOrdering(); // the order of the entered in data by the user
		
		int numRecords = transposedRows.length; // the number of records entered in
		
		while(iter.hasNext()) { // checks to see if the map has a next value to iterate to
			int index = UserDataFormatter.indexOf(userColumnOrdering, iter.next());
			if (index == -1) {
				transModRows.add(new String[numRecords]); // adds an empty array if data was not entered for this column
			} else {
				transModRows.add(transposedRows[index]); // adds the array of column data entered in by the user
			}
		}
		
		String[][] modRows = UserDataFormatter.twoDimArray(transModRows); // cast it to an array
		return UserDataFormatter.transpose(modRows); // transpose back to get records in table format
	}
	
	/**
	 * Returns the first index of a String in a String[] array, -1 if the String is not in the array.
	 * @param array	the array
	 * @param str	the string to find in the array
	 * @return	the index of the first occurrence of a String, -1 if String not in array
	 */
	public static int indexOf(String[] array, String str) {
		if (array.length == 0) {
			return -1;
		}
		for (int i = 0; i < array.length; i++) {
			if (str.equals(array[i])) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns a String[][] array of an ArrayList<String[]>.
	 * @param toArray	the ArrayList to be a String[][] array
	 * @return			the String[][] array of the ArrayList
	 */
	public static String[][] twoDimArray(ArrayList<String[]> toArray) {
		return toArray.toArray(new String[toArray.size()][toArray.get(0).length]);
	}
	
	/**
	 * Returns an ArrayList<String[]> of a String[][] array.
	 * @param toArrayList	the array to be an ArrayList<String[]>
	 * @return	the ArrayList<String[]> of the array
	 */
	public static ArrayList<String[]> twoDimArrayList(String[][] toArrayList) {
		return new ArrayList<>(Arrays.asList(toArrayList));
	}
}
