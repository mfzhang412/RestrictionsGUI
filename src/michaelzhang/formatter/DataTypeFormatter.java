package michaelzhang.formatter;

import java.util.Map;
import java.util.HashMap;

/**
 * Logic to convert a record into a properly formatted String[].
 * Properly formatted means that each value of the record will be formatted to fit its respective data type.
 * For example, in Oracle a date value of 9999-12-31 in the record would be formatted to
 * TO_DATE('9999-12-31', 'YYYY-MM-DD').
 * @author michael.zhang
 *
 */
public class DataTypeFormatter {
	/* Mapping for a data type to its correct formatting in Oracle */
	final static Map<String,String> ORACLE_FORMAT = createOracleMap();
	/* Mapping for a data type to its correct formatting in MySQL */
	final static Map<String,String> MYSQL_FORMAT = createMySQLMap();
	/* Mapping for a data type to its correct formatting in PostgreSQL */
	final static Map<String,String> POSTGRESQL_FORMAT = createPostgreSQLMap();
	
	/**
	 * Create a hash map that maps a data type to a string to be formatted in an Oracle SQL database type.
	 * Each data type will map to a specific string that will then later be formatted to hold the
	 * correct SQL data. For example, data type DATE maps to TO_DATE('%S', 'YYYY-MM-DD'), where %s
	 * will be formatted with the correct format using String.format(format, args).
	 * @return	HashMap<String,String> of data type to String format mapping
	 */
	private static HashMap<String,String> createOracleMap() {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("CHAR","'%s'");
		map.put("VARCHAR", "'%s'");
		map.put("LONGVARCHAR", "'%s'");
		map.put("DATE", "TO_DATE('%S', 'YYYY-MM-DD')");
		map.put("TIMESTAMP", "TIMESTAMP '%s'");
		map.put("NUMBER", "%s");
		return map;
	}
	
	/**
	 * Create a hash map that maps a data type to a string to be formatted in a MySQL database type.
	 * Each data type will map to a specific string that will then later be formatted to hold the
	 * correct SQL data. For example, data type DATE maps to TO_DATE('%S', 'YYYY-MM-DD'), where %s
	 * will be formatted with the correct format using String.format(format, args).
	 * @return	HashMap<String,String> of data type to String format mapping
	 */
	private static HashMap<String,String> createMySQLMap() {
		HashMap<String,String> map = new HashMap<String,String>();
		return map;
	}
	
	/**
	 * Create a hash map that maps a data type to a string to be formatted in a PostgreSQL database type.
	 * Each data type will map to a specific string that will then later be formatted to hold the
	 * correct SQL data. For example, data type DATE maps to TO_DATE('%S', 'YYYY-MM-DD'), where %s
	 * will be formatted with the correct format using String.format(format, args).
	 * @return	HashMap<String,String> of data type to String format mapping
	 */
	private static HashMap<String,String> createPostgreSQLMap() {
		HashMap<String,String> map = new HashMap<String,String>();
		return map;
	}
	
	/**
	 * Format a record into the correct Oracle SQL data type.
	 * @param dataTypes	the array of data types
	 * @param record	the record to be formatted
	 * @return	the formatted record
	 */
	private static String[] oracleSingleFormatter(String[] dataTypes, String[] record) {
		String[] r = new String[record.length];
		for (int i = 0; i < record.length; i++) {
			if (record[i] == null) {
				r[i] = "NULL";
			} else {
				String formatString = null;
				if ((formatString = ORACLE_FORMAT.get(dataTypes[i])) == null) {
					r[i] = new String(record[i]);
				} else {
					r[i] = String.format(formatString, record[i]);
				}
			}
		}
		return r;
	}
	
	/**
	 * Format an array of String[][] records into their correct Oracle SQL data types.
	 * For example, in Oracle a date value of 9999-12-31 in the record would be formatted to
	 * TO_DATE('9999-12-31', 'YYYY-MM-DD').
	 * @param columnOrderedDataTypes	the table's data types in correct order
	 * @param records					the records to be formatted
	 * @return	the formatted records
	 */
	public static String[][] oracleFormatter(String[] columnOrderedDataTypes, String[][] records) {
		String[][] r = new String[records.length][records[0].length];
		for (int i = 0; i < records.length; i++) {
			r[i] = DataTypeFormatter.oracleSingleFormatter(columnOrderedDataTypes, records[i]);
		}
		return r;
	}
}
