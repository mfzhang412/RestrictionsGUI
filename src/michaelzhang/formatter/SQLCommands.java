package michaelzhang.formatter;

/**
 * Formats strings for the basic SQL commands: create, select, modify/update, and delete for record(s) in a table.
 * @author Michael Zhang
 *
 */
public class SQLCommands {

	/**
	 * Returns the string required to insert a single record into a table.
	 * @param tableName			the table's name to have the record inserted to
	 * @param formattedRecord	the record's contents in correct data type formatting
	 * @return	the string for inserting a record
	 */
	public static String insert(String tableName, String[] formattedRecord) {
		return String.format("INSERT INTO %1$s VALUES (%2$s)", tableName, String.join(", ", formattedRecord));
	}

//	/**
//	 * Returns the string required to get record(s) from a table.
//	 */
//	public static String select() {
//		return "";
//	}
//	
//	/**
//	 * Returns the string required to modify/update record(s) of a table.
//	 */
//	public static String modify() {
//		return "";
//	}
//	
//	/**
//	 * Returns the string required to delete record(s) from a table.
//	 */
//	public static String delete() {
//		return "";
//	}
}