package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;

public class ReadExcel {
	public String[][] readExcel(String fileName) throws IOException {
		FileInputStream impFile = new FileInputStream(new File("./data/"+fileName+".xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(impFile);
		XSSFSheet sheet =workbook.getSheetAt(0);
		int rowCount =sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][columnCount];
		for (int i = 1; i <=rowCount; i++) {
			for (int j = 0; j <columnCount; j++) {
				XSSFRow row = sheet.getRow(i);
				if ( row.getCell(j).getCellType()==row.getCell(j).CELL_TYPE_NUMERIC) {
					data[i-1][j] = Double.toString(row.getCell(j).getNumericCellValue());
				}else if (row.getCell(j).getCellType()==row.getCell(j).CELL_TYPE_STRING) {
					data[i-1][j] =row.getCell(j).getStringCellValue();
				}
			}
		}
		workbook.close();
		return data;

	}

}
