package testing;

import michaelzhang.fileinteraction.*;
import michaelzhang.formatter.*;
import michaelzhang.graphicalinterface.*;
import michaelzhang.tableinteraction.*;
import michaelzhang.tablesinformation.*;
import michaelzhang.user.*;

import java.util.*;

public class TestClass {
	public static void main(String[] args) {
		CSVContents file = new CSVContents("C:/Users/michael.zhang/Documents/testing.csv");
		String[][] rows = UserDataFormatter.twoDimArray(file.getAllRows());
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < rows[i].length; j++) {
				System.out.print(rows[i][j]);
			}
			System.out.println("\t" + rows[i].length);
		}
	}
}
