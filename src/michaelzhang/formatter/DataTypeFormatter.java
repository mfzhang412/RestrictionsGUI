package michaelzhang.formatter;

import michaelzhang.user.UserPreferences;
import java.util.Map;
import java.util.HashMap;

/*
 * Contains all the format options for converting a value to the correct representation in SQL language.
 */
public class DataTypeFormatter {
	final static Map<String,String> ORACLE_FORMAT = createOracleMap();
	final static Map<String,String> MYSQL_FORMAT = createMySQLMap();
	final static Map<String,String> POSTGRESQL_FORMAT = createPostgreSQLMap();
	
	private static HashMap<String,String> createOracleMap() {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("VARCHAR","'%s'");
		return map;
	}
	
	private static HashMap<String,String> createMySQLMap() {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("", "");
		return map;
	}
	
	private static HashMap<String,String> createPostgreSQLMap() {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("", "");
		return map;
	}
	
	private static String[] oracleSingleFormatter(String[] dataTypes, String[] record) {
		String[] r = new String[record.length];
		for (int i = 0; i < record.length; i++) {
			if (record[i].equals("")) {
				r[i] = "NULL";
			} else {
				String formatString = ORACLE_FORMAT.get(dataTypes[i]);
				r[i] = String.format(formatString, record[i]);
			}
		}
		return r;
	}
	
	public String[][] oracleFormatter(UserPreferences prefs, String[][] records) {
		String[] dataTypes = prefs.getTableInformation().getColumnOrderedDataTypes();
		String[][] r = new String[records.length][records[0].length];
		for (int i = 0; i < records.length; i++) {
			r[i] = DataTypeFormatter.oracleSingleFormatter(dataTypes, records[i]);
		}
		return r;
	}
}
