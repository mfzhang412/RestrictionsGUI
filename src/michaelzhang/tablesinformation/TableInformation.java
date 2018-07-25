package michaelzhang.tablesinformation;
/*
 * keeps the data a tables: PK column, data types, column headers, table name.
 */
public class TableInformation {
	final private String TABLE_NAME;
	final private String[] COLUMN_ORDERED_NAMES;
	final private String[] COLUMN_ORDERED_DATA_TYPES;
	
	public TableInformation(String tableName, String[] columnNameOrder, String[] columnDataOrder) {
		this.TABLE_NAME = tableName;
		this.COLUMN_ORDERED_NAMES = columnNameOrder;
		this.COLUMN_ORDERED_DATA_TYPES = columnDataOrder;
	}
	
	public String getTableName() {
		return TABLE_NAME;
	}
	
	public String[] getColumnOrderedNames() {
		return COLUMN_ORDERED_NAMES;
	}
	
	public String[] getColumnOrderedDataTypes() {
		return COLUMN_ORDERED_DATA_TYPES;
	}
}
