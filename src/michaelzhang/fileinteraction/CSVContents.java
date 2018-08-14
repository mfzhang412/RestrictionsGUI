package michaelzhang.fileinteraction;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * This class takes a location and stores the contents of a .csv file in an ArrayList<String[]> format.
 * The stored contents includes every row of the .csv file. Note that each row gets stored
 * one by one, so if an error occurs, the instance variable allRows may be only partially complete. The
 * ArrayList<String[]> follows the data pattern: each row of the .csv file will be split into a String[]
 * where each cell is a separate index; the String[] is then placed in the ArrayList.
 * @author Michael Zhang
 * 
 */
public class CSVContents {
	/* The location of the .csv file */
	final private String FILE_LOCATION;
	/* Contains all the rows of the .csv file (rows are added in one by one until .csv file ends) */
	private ArrayList<String[]> allRows;
	
	/**
	 * Save the location of the file as an instance variable and read the contents of the file.
	 * @param loc	the location of the .txt or .csv file
	 */
	public CSVContents(String loc) {
		this.FILE_LOCATION = loc;
		this.allRows = new ArrayList<String[]>();
		this.readCSVContents();
	}
	
	/**
	 * Read all the contents of the .csv file and store them as an instance variable.
	 * Returns true if successfully stored all contents, false otherwise.
	 * @return	true if all records stored, false otherwise
	 */
	private boolean readCSVContents() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(FILE_LOCATION));
			String line;
			while ((line = br.readLine()) != null) {
				String[] contents = line.split(",");
				this.allRows.add(contents);
			}
			br.close();
			return true;
		} catch (Exception e) {
			if (br != null) {
				try {
					br.close();
				} catch (Exception ex) {/* do nothing */}
			}
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Return all the contents of the .csv file as an ArrayList<String[]>.
	 * Note that this includes the first line, which may or may not be a record to be
	 * entered or column headers to be removed later.
	 * @return	the contents of the .csv file as an ArrayList<String[]>
	 */
	public ArrayList<String[]> getAllRows() {
		return this.allRows;
	}
}
