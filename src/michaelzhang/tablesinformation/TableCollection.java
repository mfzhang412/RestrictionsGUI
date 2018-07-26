package michaelzhang.tablesinformation;

import michaelzhang.user.UserPreferences;
import java.util.ArrayList;

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
	 * Fetches information corresponding to each table in a database and stores them in an ArrayList instance variable.
	 * Gathers information about each table in a database, creates a new TableInformation object and
	 * adds that to a list. Once all of the tables in the database have been represented as a TableInformation
	 * object, save them in an ArrayList.
	 * @param prefs	object that contains database access information
	 */
	public TableCollection(UserPreferences prefs) { //could make this an entirely new class and simply have a TableCollection constructor that takes no parameters but have an addTable(TableInformation table) method. (this is probably better, will implement it later).
	// make this part of a new class to gather table information and create Table objects to then pass into an addTable method in TableCollecion class.	
		// do: get the database from UserPreferences
		// do: run a loop or get some way to create a bunch of TableInformation objects for
			// each table in the database. add it to an ArrayList<TableInformation>
		// do: convert ArrayList<TableInformation> to a temporary array
		// do: set TABLES instance variable to the temporary array
	}
	
	/**
	 * Adds a TableInformation object to an ArrayList<TableInformation> collection.
	 * Returns true if the TableInformation object was inserted and false if that object
	 * already exists in the collection.
	 * @param table	the TableInformation object to be inserted
	 * @return	true if successful, false otherwise (object already in collection)
	 */
	public boolean addTable(TableInformation table) {
		return this.tables.add(table);
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
		for (TableInformation t: tables) {
			if (t.getIdentification().equals(id)) {
				return t;
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
		return this.tables.toArray(new TableInformation[this.tables.size()]);
	}
}
