package michaelzhang.tablesinformation;
/*
 * keeps the data for a table: PK column, data types, column headers, table name, identification.
 */
public class TableInformation {
	final private String IDENTIFICATION;
	final private String TABLE_NAME;
	final private String[] COLUMN_ORDERED_NAMES;
	final private String[] COLUMN_ORDERED_DATA_TYPES;
	
	public TableInformation(String id, String tableName, String[] columnNameOrder, String[] columnDataOrder) {
		this.IDENTIFICATION = id;
		this.TABLE_NAME = tableName;
		this.COLUMN_ORDERED_NAMES = columnNameOrder;
		this.COLUMN_ORDERED_DATA_TYPES = columnDataOrder;
	}
	
	public String getIdentification() {
		return this.IDENTIFICATION;
	}
	
	public String getTableName() {
		return this.TABLE_NAME;
	}
	
	public String[] getColumnOrderedNames() {
		return this.COLUMN_ORDERED_NAMES;
	}
	
	public String[] getColumnOrderedDataTypes() {
		return this.COLUMN_ORDERED_DATA_TYPES;
	}
}
