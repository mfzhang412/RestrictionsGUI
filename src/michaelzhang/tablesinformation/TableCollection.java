package michaelzhang.tablesinformation;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import michaelzhang.user.UserPreferences;

/**
 * Structure to contain all of the TableInformation objects in an accessed database.
 * A database is passed in and then all of the tables in the database are created as
 * TableInformation objects. The TableInformation objects are then stored in an
 * ArrayList<TableInformation> as an instance variable.
 * @author Michael Zhang
 *
 */
public class TableCollection {
	/* An ArrayList of all the tables in the database. Note, TableInformation objects don't contain actual records. */
	private ArrayList<TableInformation> tables;
	
	/**
	 * Fetch information corresponding to each table in a database and store them in an ArrayList instance variable.
	 * Gathers information about each table in a database, creates a new TableInformation object and
	 * adds that to a list. Once all of the tables in the database have been represented as a TableInformation
	 * object, save them in an ArrayList.
	 * @param conn			Connection object to the database
	 * @param databaseName	the database name
	 * @param prefs	object 	that contains database access information
	 */
	public TableCollection(Connection conn, String databaseName, UserPreferences prefs) {
		ResultSet rs = null;
		try {
			DatabaseMetaData md = conn.getMetaData();
			rs = md.getTables(databaseName, null, "TABLE_NAME", null);
			while (rs.next()) {
				String tableName = rs.getString(3);
				ResultSet tableInfo = null;
				try {
					tableInfo = md.getColumns(null, null, tableName, null);
					int size = tableInfo.getInt("COLUMN_SIZE");
					String[] colNames = new String[size];
					String[] colTypes = new String[size];
					int i = 0;
					while (tableInfo.next()) {
						colNames[i] = tableInfo.getString("COLUMN_NAME");
						colTypes[i] = tableInfo.getString("TYPE_NAME");
						i++;
					}
					TableInformation t = new TableInformation(tableName, colNames, colTypes);
					this.addTable(t);
				} catch (SQLException se) {
					se.printStackTrace();
				} finally {
					try {
						if (tableInfo != null) tableInfo.close();
					} catch (SQLException e) {
						/* do nothing */
					}
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
			} catch (SQLException e) {
				/* do nothing */
			}
		}
		
	}
	
	/**
	 * Add a TableInformation object to an ArrayList<TableInformation> collection.
	 * Returns true if the TableInformation object was inserted and false if that object
	 * already exists in the collection.
	 * @param table	the TableInformation object to be inserted
	 * @return	true if successful, false otherwise (object already in collection)
	 */
	public boolean addTable(TableInformation table) {
		return this.tables.add(table);
	}
	
	/**
	 * Return a specific TableInformation object.
	 * If the identification issued in the parameter is the same as a TableInformation
	 * object's identification, then that TableInformation object will be returned. Note,
	 * if id doesn't match any TableInformation object's identification, null will be
	 * returned. Note also that a TableInformation object doesn't actually contain
	 * any records, just basic table overview information.
	 * @param id	the identification used to get a Table
	 * @return	a TableInformation object, null if identification not located
	 */
	public TableInformation getTable(String id) {
		for (TableInformation t: tables) {
			if (t.getIdentification().equals(id)) {
				return t;
			}
		}
		return null;
	}
	
	/**
	 * Return an array of TableInformation objects.
	 * The array will contain a TableInformation for every table in UserPreferences specified database.
	 * @return
	 */
	public TableInformation[] getTables() {
		return this.tables.toArray(new TableInformation[this.tables.size()]);
	}
}
