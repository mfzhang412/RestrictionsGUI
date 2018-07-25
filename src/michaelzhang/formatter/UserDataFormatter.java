package michaelzhang.formatter;

import michaelzhang.user.UserPreferences;
import michaelzhang.tablesinformation.TableInformation;
import java.util.ArrayList;

/*
 * Contains all the format options for the incoming user data.
 * Consider making this an interface to accommodate for different databases.
 */
public class UserDataFormatter {
	
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
	
	public static ArrayList<String[]> modDataTypes(UserPreferences prefs, ArrayList<String[]> rows) {
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
		for (int i = 0; i < userOrderDataTypes.size(); i++) {
			SQLFormatter.format(rows)
		}
		
		
		return new ArrayList<String[]>();
	}
	
	public static ArrayList<String[]> orderList(UserPreferences prefs, ArrayList<String[]> rows) {
		return new ArrayList<String[]>();
	}
}
