package michaelzhang.fileinteraction;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

/* stores the contents of the csv file */
public class CSVContents {
	final private String FILE_LOCATION; /* location of the csv file */
	private ArrayList<String[]> allRows; /* all the rows of the csv file */
	
	/**
	 * Saves the location of the file as an instance variable
	 * and reads all the contents of the file.
	 * @param loc	the location of the .csv file
	 */
	public CSVContents(String loc) {
		this.FILE_LOCATION = loc;
		this.allRows = new ArrayList<String[]>();
		this.readCSVContents();
	}
	/**
	 * Reads all the contents of the .csv file and stores them in records instance variable.
	 * Returns true if successfully stored all records, false otherwise.
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
	 * Returns all the contents of the .csv file as an ArrayList<String[]>.
	 * Note that this includes the first line, which may or may not be a record to be
	 * entered or column headers to be removed later.
	 * @return	the contents of the .csv file as an ArrayList<String[]>
	 */
	public ArrayList<String[]> getAllRows() {
		return this.allRows;
	}
}
