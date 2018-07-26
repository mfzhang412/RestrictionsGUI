package michaelzhang.tablesinformation;

import java.util.Map;
import java.util.LinkedHashMap;

/**
 * Contains information on the overview of a table in a database.
 * The contained information includes an identification, the name of the table, the column
 * names and their respective data types in correct ordering with respect to the table
 * in the database. Note that the default for the TableInformation's identification
 * instance variable is the table name passed in. The TableInformation identification
 * is able to be changed while the TableInformation's table name is declared final.
 * @author michael.zhang
 *
 */
public class TableInformation {
	/* The name of the table taken from the database. */
	final private String TABLE_NAME;
	/* Table ordered LinkedHashTable with keys as the table's column names and values as the table's column data types. */
	final private Map<String,String> COLUMN_ORDER;
	/* An identification code for the TableInformation object. Used to identify a TableInformation object. */
	private String identification;
	
	/**
	 * Associates an id and name to a table as well as an ordered LinkedHashTable column names and column data types.
	 * The TableInformation identification instance variable is allowed to change via a setIdentification
	 * method. The TABLE_NAME instance variable, however, is declared final and thus cannot change. The
	 *  is in the order of the table's columns with the keys being the column names and the values
	 * being the associated data types of those columns. Note that the default TableInformation constructor
	 * doesn't take an id parameter and instead defaults the identification to the table name.
	 * @param id				an identification code for the table
	 * @param tableName			name of the table
	 * @param columnNameOrder	table's column names in the order given by the table
	 * @param columnDataOrder	table's column data types in the order given by the table
	 */
	public TableInformation(String id, String tableName, String[] columnNameOrder, String[] columnDataOrder) {
		this.identification = id;
		this.TABLE_NAME = tableName;
		this.COLUMN_ORDER = new LinkedHashMap<String,String>();
		for (int i = 0; i < columnNameOrder.length; i++) {
			COLUMN_ORDER.put(columnNameOrder[i], columnDataOrder[i]);
		}
	}
	
	/**
	 * Associates an id and name to a table as well as an ordered LinkedHashTable column names and column data types.
	 * This constructor defaults the TableInformation object's identification to the passed in table name.
	 * The TableInformation identification instance variable is allowed to change via a setIdentification
	 * method. The TABLE_NAME instance variable, however, is declared final and thus cannot change. The
	 *  is in the order of the table's columns with the keys being the column names and the values
	 * being the associated data types of those columns. Note that the default TableInformation constructor
	 * doesn't take an id parameter and instead defaults the identification to the table name.
	 * @param tableName			name of the table
	 * @param columnNameOrder	table's column names in the order given by the table
	 * @param columnDataOrder	table's column data types in the order given by the table
	 */
	public TableInformation(String tableName, String[] columnNameOrder, String[] columnDataOrder) {
		this.identification = tableName; // identification defaults to the table name
		this.TABLE_NAME = tableName;
		this.COLUMN_ORDER = new LinkedHashMap<String,String>();
		for (int i = 0; i < columnNameOrder.length; i++) {
			COLUMN_ORDER.put(columnNameOrder[i], columnDataOrder[i]);
		}
	}
	
	/**
	 * Sets the identification of the TableInformation object.
	 * @param id	the new identification to be ascribed
	 */
	public void setIdentification(String id) {
		this.identification = id;
	}
	
	/**
	 * Returns the TableInformation object's identification.
	 * @return	the TableInformation's id
	 */
	public String getIdentification() {
		return this.identification;
	}
	
	/**
	 * Returns the TableInformation object's table name.
	 * @return	the TableInformation's table name
	 */
	public String getTableName() {
		return this.TABLE_NAME;
	}
	
	/**
	 * Returns the LinkedHashTable of the table's column order.
	 * The LinkedHashTable has keys of the table's column names and values of the table's column data types.
	 * Note, the LinkedHashTable is ordered in the order of the table's columns.
	 * @return	the LinkedHashTable of the table's column names and data types
	 */
	public Map<String,String> getColumnOrder() {
		return this.COLUMN_ORDER;
	}
	
	/**
	 * Returns the associated table's column names in the order they appear in the database table.
	 * @return	the associated table's column names in order
	 */
	public String[] getColumnOrderedNames() {
		return this.COLUMN_ORDER.keySet().toArray(new String[this.COLUMN_ORDER.keySet().size()]);
	}
	
	/**
	 * Returns the associated table's column data types in the order they appear in the database table.
	 * @return	the associated table's column data types in order
	 */
	public String[] getColumnOrderedDataTypes() {
		return this.COLUMN_ORDER.values().toArray(new String[this.COLUMN_ORDER.values().size()]);
	}
}
