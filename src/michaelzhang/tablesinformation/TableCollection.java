package michaelzhang.tablesinformation;

import michaelzhang.user.UserPreferences;

/**
 * Structure to contain all of the TableInformation objects in an accessed database.
 * A database is passed in and then all of the tables in the database are created as
 * TableInformation objects. The TableInformation objects are then stored in an array
 * as an instance variable.
 * @author Michael Zhang
 *
 */
public class TableCollection {
	/* An array of all the tables in the database. Note, TableInformation objects don't contain actual records. */
	final private TableInformation[] TABLES;
	
	/**
	 * Fetches information corresponding to each table in a database and stores them in an array instance variable.
	 * Gathers information about each table in a database, creates a new TableInformation object and
	 * adds that to a list. Once all of the tables in the database have been represented as a TableInformation
	 * object, save them in an array.
	 * @param prefs	object that contains database access information
	 */
	public TableCollection(UserPreferences prefs) {
		// do: get the database from UserPreferences
		// do: run a loop or get some way to create a bunch of TableInformation objects for
			// each table in the database. add it to an ArrayList<TableInformation>
		// do: convert ArrayList<TableInformation> to a temporary array
		// do: set TABLES instance variable to the temporary array
	}

	/**
	 * Returns a specific TableInformation object.
	 * If the identification issued in the parameter is the same as a TableInformation
	 * object's identification, then that TableInformation object will be returned. Note,
	 * if id doesn't match any TableInformation object's identification, null will be
	 * returned. Note also that a TableInformation object doesn't actually contain
	 * any records, just basic table overview information.
	 * @param id	the identification used to get a Table
	 * @return	a TableInformation object, null if identification not located
	 */
	public TableInformation getTable(String id) {
		for (TableInformation table: TABLES) {
			if (table.getIdentification().equals(id)) {
				return table;
			}
		}
		return null;
	}
	
	/**
	 * Returns an array of TableInformation objects.
	 * The array will contain a TableInformation for every table in UserPreferences specified database.
	 * @return
	 */
	public TableInformation[] getTables() {
		return this.TABLES;
	}
}
