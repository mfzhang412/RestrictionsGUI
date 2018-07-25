package michaelzhang.tablesinformation;
/*
 * stores all of the Tables information in an arrayList
 */
public class TableCollection {
	TableInformation[] tables = {new TableInformation()};

	public TableInformation getTable(String tableName) {
		for (TableInformation table: tables) {
			if (table.getTableName().equals(tableName)) {
				return table;
			}
		}
		return null;
	}
	
	public TableInformation[] getTables() {
		return this.tables;
	}
}
