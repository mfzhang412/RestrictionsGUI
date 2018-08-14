package michaelzhang.tableinteraction;

import michaelzhang.user.UserPreferences;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Inserts records into a table given a String[] array of SQL queries.
 * @author michael.zhang
 *
 */
public class InsertUserRecords {
	
	/**
	 * Insert records into the table defined in the UserPreferences object.
	 * @param prefs					UserPreferences object
	 * @param sqlFormattedRecords	array of Strings of SQL queries
	 * @return	true if all records inserted successfully, false otherwise
	 */
	public static boolean insertRecords(UserPreferences prefs, String[] sqlFormattedRecords) {
		String jdbcDriver = prefs.getJDBCDriver();
		String dbURL = prefs.getDatabaseURL();
		String username = prefs.getUsername();
		String password = prefs.getPassword();
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(jdbcDriver); // register jdbc driver
			conn = DriverManager.getConnection(dbURL, username, password); // open a connection
			stmt = conn.createStatement(); // execute queries
			for (int i = 0; i < sqlFormattedRecords.length; i++) { // insert records
				stmt.executeUpdate(sqlFormattedRecords[i]);
			}
			return true; // all records successfully inserted
		} catch(SQLException se) {
			se.printStackTrace();
			return false;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					conn.close();
				}
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
