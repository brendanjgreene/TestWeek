package testingweek;

import java.util.List;

import org.junit.Test;

import testingweek.SpreadSheetExample;

public class ReadSpreadSheet {
	String username;
	String password;
	
	@Test
	public void spreadSheet() {
		SpreadSheetExample sheetReader = new SpreadSheetExample(System.getProperty("user.dir") + "/Example_Spreadsheet.xlsx");
		List<String> row = sheetReader.readRow(1, "Input Data");
		username = row.get(2);
		password = row.get(3);
		
		System.out.println("should be username " + username);
		System.out.println("should be password " + password);
		
		for(String cell : row) {
			System.out.println(cell);
		}
	}

}
