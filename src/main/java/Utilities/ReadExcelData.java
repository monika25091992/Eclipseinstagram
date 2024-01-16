package main.java.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	private String fileSeperator = System.getProperty("file.separator");
	private String ExcelDataSheet = System.getProperty("user.dir") + fileSeperator + "Utilities";
	private String ExcelDataSheetpath = ExcelDataSheet + fileSeperator + "DataSheet.xlsx";

	public String readData(String testcasename, String columnname, String sheetname) {
		String cellitemvalue=null;
		try {
			
			FileInputStream file = new FileInputStream(new File(ExcelDataSheetpath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(workbook.getSheetIndex(sheetname));
			Iterator<Row> rowIterator = sheet.iterator();
			int testcasecol = -1, testdatacol = -1;
			Cell data;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (testcasecol != -1 && testdatacol != -1) {
					Cell testcasenamecell = row.getCell(testcasecol);
					if (testcasenamecell.getStringCellValue().equals(testcasename)) {
						 data = row.getCell(testdatacol);
						System.out.println("testdata is " + data.getStringCellValue().split("--")[1]);
						for(String s:data.getStringCellValue().split("--")[1].split(",,"))
						{
							System.out.println("question headers - " + s);
						}
						cellitemvalue=data.getStringCellValue().split("--")[1];
						return cellitemvalue;
					}
				} else {
					Iterator<Cell> cellIterator = row.cellIterator();

					while (cellIterator.hasNext()) {

						Cell cell = cellIterator.next();
						if (cell.getStringCellValue().equals("TestCaseName")) {
							testcasecol = cell.getColumnIndex();
						}
						if (cell.getStringCellValue().equals(columnname)) {
							testdatacol = cell.getColumnIndex();
						}
					}
					
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellitemvalue;
	
		
		

	}

}
