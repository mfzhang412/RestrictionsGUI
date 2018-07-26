package michaelzhang.formatter;

import michaelzhang.user.UserPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/*
 * Contains all the format options for the incoming user data.
 * Consider making this an interface to accommodate for different databases.
 */
public class UserDataFormatter {
	
	
	public static String[][] transpose(String[][] matrix) {
		int m = matrix.length;
	    int n = matrix[0].length;

	    String[][] trasposedMatrix = new String[n][m];

	    for(int x = 0; x < n; x++)
	    {
	        for(int y = 0; y < m; y++)
	        {
	            trasposedMatrix[x][y] = matrix[y][x];
	        }
	    }

	    return trasposedMatrix;
	}
	
	public static String[][] fitDataToTable(UserPreferences prefs, ArrayList<String[]> rows) {
		String[][] matrix = rows.toArray(new String[rows.size()][rows.get(0).length]); // converts rows to String[][]
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
		
		String[][] modRows = transModRows.toArray(new String[transModRows.size()][transModRows.get(0).length]); // cast it to an array
		return UserDataFormatter.transpose(modRows); // transpose back to get records in table format
	}
	
	
	
	private static int indexOf(String[] array, String str) {
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
	
//	public static ArrayList<String[]> modDataTypes(UserPreferences prefs, ArrayList<String[]> rows) {
		/*
		// get user declared data ordering
		String[] userOrdering = prefs.getColumnOrdering();
		// get the datatypes corresponding to each column declared data
		TableInformation tables = prefs.getTableInformation();
		String[] tableOrderedNames = tables.getColumnOrderedNames();
		String[] tabledOrderedDataTypes = tables.getColumnOrderedDataTypes();
		// format each according to their data type and database type (for now use Oracle database type)
		int[] userOrderIndices = new int[userOrdering.length];
		for (int i = 0; i < userOrderIndices.length; i++) {
			userOrderIndices[i] = UserDataFormatter.indexOf(tableOrderedNames, userOrdering[i]);
		}
		ArrayList<String> userOrderDataTypes = new ArrayList<String>();
		for (int num: userOrderIndices) {
			userOrderDataTypes.add(tabledOrderedDataTypes[num]);
		}
		for (int i = 0; i < rows.size(); i++) {
			String[] toInsert = new String[rows.get(0).length];
			for (int j = 0; j < userOrderDataTypes.size(); j++) {
				SQLFormatter.format();
			}
		}
		
		*/
//		return new ArrayList<String[]>();
//	}
	
//	public static ArrayList<String[]> orderList(UserPreferences prefs, ArrayList<String[]> rows) {
//		return new ArrayList<String[]>();
//	}
}
