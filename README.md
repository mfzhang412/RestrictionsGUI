# RestrictionsGUI

Program's function:
This program's function is to be a GUI for inserting records into a table.


Current state:
The backend of the program is coded, but the front end (GUI) is not.


Program's current function:
Read in a .csv file and automatically enter in the formatted data into an Oracle database.


The nitty gritty (what the program can do):
At the moment, the program takes in a database URL, JDBC driver name, database username, and database password, as well as a
String of what database type it is (Oracle, MySQL, PostgreSQL, etc). The program then retrieves all of the tables from the
database and populates dummy classes that hold information about each table (table name, the column names in order (as they
appear in the table), and the respective datatypes (for example: VARCHAR, DATE, NUMBER, etc). The program then receives the
name of a specific table to insert records into. Then, the program receives a .csv file with user data (as well as the order
of data) and automatically enters formats the data and executes the SQL insertion statements.


GUI idea:
The user will be able to select/type a database from a list. Then the user will be able to choose a table (in the database).
Then the user will drag and drop a .csv file into a window (or choose a file path via the JFileChooser class). The user will
then be able to choose the column ordering that they entered in data. Afterwards, they hit a submit button and the records will
be automatically inserted.


Moving forward (what steps need to be done for a fully functional GUI):
The intermediary between backend and frontend is the UserPreferences class in the program. The GUI needs to receive information from
the user and then simply call a setter method on their UserPreferences object. The UserPreferences object will then be passed around
in the backend and automatically complete the insertion.


Program's final workflow once everything is done:
User chooses database name from list. Program's DatabaseInformation object is then populated with information from an external file
that maps the database name to the following information: database URL, JDBC driver name, database username, database password, database
type (Oracle, MySQL, PostgreSQL, etc). A UserPreferences object 'prefs' is created. The program calls prefs.setDatabaseInformation where
the DatabaseInformation object is passed in. A TableCollection object is created. The Connection object corresponding to the database
connection, the database name, and the 'prefs' object is then passed into the TableCollection object. The TableCollection object then
automatically receives all of the relevant information about the tables in the database. The program then calls
prefs.getTableCollection().getTables() which returns an array of TableInformation objects. The program then iterates through the
TableInformation objects, retrieving their name with getTableName(). The program then retrieves an external file which maps the table names
to names that the user is familiar with. The program then displays those options to the user. The user then chooses which table they want to
insert records into. The program then calls prefs.setTableInformation(prefs.getTableCollection().getTable(tableName)) where tableName
is the table's name that the user has chosen (tableName should be the actual name as written in the database). The user then chooses their file
location with their data. The program then calls prefs.setFileLocation(loc) where loc is the file's path. The user then chooses whether the first
row is part of the data to be inserted (true = first row is not to be inserted, false = first row is to be inserted). The user then chooses
the order that their data is in (the columns should correspond to the actual column names). The String array of the user ordered columns are then
passed into prefs.setColumnOrdering(userOrder) where userOrder is the order of the user's data (note that empty columns should not be represented
with null or "", but instead just be deleted when passed in to setColumnOrdering). In the code, everything under the comment "process data and insert records"
is all in the order as it should be. The program then finishes.













