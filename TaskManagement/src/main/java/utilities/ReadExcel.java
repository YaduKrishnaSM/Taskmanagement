package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadExcel {
	private static FileInputStream file = null;
	private static Workbook wb = null;
	private static Sheet ws = null;
	private static Cell cell;
	private static Cell methodCell;
	private static Row row;
	private static CellType type;
	// private static String filelocation = Base.getTestDataPath();

	public static Object[][] ReadTestData(String wsName, String MethodName, int colCount) {
		try {
			file = new FileInputStream("./TestData.xlsx");
			wb = WorkbookFactory.create(file);
			ws = wb.getSheetAt(0);
		} catch (Exception e) {
			System.out.println(e);
		}

		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex == -1)
			return null;
		else {
			int k = 0;
			int matchingRows = 0;
			ws = wb.getSheetAt(sheetIndex);
			int rowCount = ws.getLastRowNum() + 1;
			// System.out.println(ws.getLastRowNum());
			for (int i = 0; i < rowCount; i++) {
				row = ws.getRow(i);
				if (row != null) {
					methodCell = row.getCell(0);
					if (methodCell != null) {
						String MethodNameinSheet = methodCell.getStringCellValue();
						if (MethodNameinSheet.equalsIgnoreCase(MethodName)) {
							matchingRows++;
						}
					}
				}
			}
			Object testdata[][] = new Object[matchingRows][colCount];
			for (int i = 0; i < rowCount; i++) {
				row = ws.getRow(i);
				if (row != null) {
					methodCell = row.getCell(0);
					if (methodCell != null) {
						String MethodNameinSheet = methodCell.getStringCellValue();
						if (MethodNameinSheet.equalsIgnoreCase(MethodName)) {
							for (int j = 0; j < colCount; j++) {
								if (row == null) {
									testdata[k][j] = "";
								} else {
									cell = row.getCell(j + 1);
									if (cell == null || cell.getCellType().equals(CellType.BLANK)) {
										testdata[k][j] = "";
									} else {
										String celldata = cellToString(cell);
										//System.out.println(celldata);
										testdata[k][j] = celldata;
									}
								}
							}
							k++;
						}
					}
				}
			}
			return testdata;
		}
	}

	public static String cellToString(Cell cell) {

		FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
		DataFormatter fmt = new DataFormatter();
		type = cell.getCellType();
		Object result;
		switch (type) {
		case NUMERIC:
			result = fmt.formatCellValue(cell);
			break;

		case STRING:
			result = cell.getStringCellValue();
			break;

		case BOOLEAN:
			result = cell.getBooleanCellValue();
			break;

		case FORMULA:
			result = fmt.formatCellValue(cell, evaluator);
			break;

		default:
			throw new RuntimeException("Identified Type : " + type);

		}
		return result.toString();
	}
}
