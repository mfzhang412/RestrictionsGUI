package michaelzhang.formatter;

/**
 * Formats strings for the basic SQL commands: create, select, modify/update, and delete for record(s) in a table.
 * @author Michael Zhang
 *
 */
public class SQLCommands {

	/**
	 * Returns the string required to insert a single record into a table.
	 * For example, if a record is ["John", "Doe", "9999-12-31"], then the method returns the
	 * following String: "INSERT INTO <table name> (FIRST_NAME, LAST_NAME, BIRTHDATE) VALUES ('John',
	 * 'Doe', TO_DATE('9999-12-31', 'YYYY-MM-DD')".
	 * @param tableName			the table's name to have the record inserted to
	 * @param colNames			the column names of the table
	 * @param formattedRecord	the record's contents in correct data type formatting
	 * @return	the string for inserting a record
	 */
	public static String insertionString(String tableName, String[] colNames, String[] formattedRecord) {
		return String.format("INSERT INTO %1$s (%2$s) VALUES (%3$s)",
				tableName, String.join(", ", colNames), String.join(", ", formattedRecord));
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