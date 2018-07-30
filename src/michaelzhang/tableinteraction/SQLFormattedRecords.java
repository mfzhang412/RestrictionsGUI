package michaelzhang.tableinteraction;

import michaelzhang.user.UserPreferences;
import michaelzhang.formatter.DataTypeFormatter;
import michaelzhang.formatter.SQLCommands;

/**
 * Takes the entire content of a String[][] and stores it according to an appropriate SQL format.
 * The appropriate format is according to the database type being used. The appropriate SQL format
 * will match the syntax of a hypothetical insertion of the data. For example, an entered date
 * 9999-12-31 may be converted to TO_DATE('9999-12-31', 'YYYY-MM-DD') depending on the database type.
 * @author michael.zhang
 *
 */
public class SQLFormattedRecords {
	/* SQL formatted data primed for insertion */
	final private String[][] SQL_FORMATTED_DATA;
	/* Array of strings primed for insertion */
	final private String[] INSERT_RECORD_STRINGS;
	
	/**
	 * Populates the SQL_FORMATTED_DATA and INSERT_RECORD_STRINGS according to the correct database type.
	 * The SQL_FORMATTED_DATA is the formatted data primed for insertion. For example, if a record's value
	 * has the date 9999-12-31, it may be converted to TO_DATE('9999-12-31', 'YYYY-MM-DD') depending on the
	 * database type. The INSERT_RECORD_STRINGS actually holds all of the Strings for inserting each record.
	 * For example, if a record is ["John", "Doe", "9999-12-31"], then the INSERT_RECORD_STRINGS stores the
	 * following String: "INSERT INTO <table name> (FIRST_NAME, LAST_NAME, BIRTHDATE) VALUES ('John', 'Doe',
	 * TO_DATE('9999-12-31', 'YYYY-MM-DD')".
	 * @param prefs		UserPreferences object
	 * @param records	unformatted SQL records
	 */
	public SQLFormattedRecords(UserPreferences prefs, String[][] records) {
		String databaseType = prefs.getDatabaseType();
		String[][] r = null;
		if (databaseType.equals("Oracle")) {
			r = DataTypeFormatter.oracleFormatter(prefs, records);
		}
//		if (databaseType.equals("PostgreSQL")) {
//			r = DataTypeFormatter.postgreSQLFormatter(prefs, records);
//		}
//		if (databaseType.equals("MySQL")) {
//			r = DataTypeFormatter.mySQLFormatter(prefs, records);
//		}
		this.SQL_FORMATTED_DATA = r;
		this.INSERT_RECORD_STRINGS = createInsertRecordStrings(prefs);
	}
	
	/**
	 * Creates the strings to be stored in INSERT_RECORD_STRINGS.
	 * For example, if a record is ["John", "Doe", "9999-12-31"], then the INSERT_RECORD_STRINGS stores
	 * the following String: "INSERT INTO <table name> (FIRST_NAME, LAST_NAME, BIRTHDATE) VALUES ('John',
	 * 'Doe', TO_DATE('9999-12-31', 'YYYY-MM-DD')".
	 * @param prefs
	 * @return
	 */
	private String[] createInsertRecordStrings(UserPreferences prefs) {
		String tableName = prefs.getTableInformation().getTableName();
		String[] colNames = prefs.getTableInformation().getColumnOrderedNames();
		String[] r = new String[SQL_FORMATTED_DATA.length];
		for (int i = 0; i < this.SQL_FORMATTED_DATA.length; i++) {
			r[i] = SQLCommands.insertionString(tableName, colNames, this.SQL_FORMATTED_DATA[i]);
		}
		return r;
	}
	
	/**
	 * Returns the SQL formatted data.
	 * @return a String[][] array of the SQL formatted data
	 */
	public String[][] getSQLFormattedData() {
		return this.SQL_FORMATTED_DATA;
	}
	
	/**
	 * Returns the Strings for inserting a record primed for insertion.
	 * @return a String[] array of the records primed for insertion
	 */
	public String[] getInsertRecordStrings() {
		return this.INSERT_RECORD_STRINGS;
	}
}
