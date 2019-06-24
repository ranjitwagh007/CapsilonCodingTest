package excelPrograms;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.Test;

public class ExcelCodingTest extends BaseClass {

	@Test(description="Assignmnent1(Question4)")
	public void highestMarks2() throws IOException {
		BaseClass.readExcel();
		double max = 0;
		Row row1 = sheet.getRow(0);
		Cell c = null;
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				if (row.getCell(j).getCellType() == CellType.NUMERIC) {
					break;
				}
				if (row.getCell(j).getStringCellValue().equals(Constants.SANKET)) {
					max = row.getCell(j + 1).getNumericCellValue();
					for (int k = j; k < row.getLastCellNum(); k++) {
						if (row.getCell(k).getCellType() == CellType.NUMERIC) {
							if (max < row.getCell(k).getNumericCellValue()) {
								c = row.getCell(k);
								max = c.getNumericCellValue();
							}

						}

					}

				}

			}
		}
		System.out.println("Maximum marks is :" + max);
		int index = c.getColumnIndex();
		System.out.println("subject having highest marks for SANKET is :" + row1.getCell(index).getStringCellValue());
		workbook.close();
	}

	@Test(description="Assignmnent1(Question4)")
	public void failedStudents1() throws IOException {
		BaseClass.readExcel();
		int count = 0;
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.print("Failed students are : ");
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				if (row.getCell(j).getCellType() == CellType.STRING) {
					if (row.getCell(j).getStringCellValue().equals(Constants.FAILED)) {
						count++;
						System.out.print( row.getCell(0).getStringCellValue()+", ");
					}
				} else {
					continue;
				}
			}

		}
		System.out.println();
		System.out.println("Count of failed students are : " + count);
		workbook.close();
	}

	@Test(description="Assignmnent1(Question4)")
	public void topperInPhysics3() throws IOException {
		BaseClass.readExcel();
		double max = 0;
		int index1 = 0;
		Row row1 = null;
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		for (int i = 0; i < columnCount + 1; i++) {
			Cell c = sheet.getRow(0).getCell(i);
			if (c.getCellType() == CellType.STRING) {
				if (c.getStringCellValue().equals(Constants.PHYSICS)) {
					index1 = c.getColumnIndex();
					max = sheet.getRow(1).getCell(i).getNumericCellValue();
					for (int j = 1; j < rowCount + 1; j++) {
						Row row = sheet.getRow(j);
						if (row.getCell(index1).getCellType() == CellType.NUMERIC) {
							if (max < row.getCell(index1).getNumericCellValue()) {
								max = row.getCell(index1).getNumericCellValue();
								row1 = sheet.getRow(j);
							}

						}
					}
					break;

				}

			}

		}
		System.out.println("maximum marks in physics is" + max);
		System.out.println("Topper in physics is :" + row1.getCell(0).getStringCellValue());
		workbook.close();

	}

	@Test(description="Assignmnent1(Question4)")
	public void similarMarksInMaths4() throws IOException {
		BaseClass.readExcel();
		int index1 = 0;
		Row row2 = null,row3=null;
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		for (int i = 0; i < columnCount + 1; i++) {
			Cell c = sheet.getRow(0).getCell(i);
			if (c.getCellType() == CellType.STRING) {
				if (c.getStringCellValue().equals(Constants.MATHS)) {
					index1 = c.getColumnIndex();
					for (int j = 1; j < rowCount + 1; j++) {
					Row row = sheet.getRow(j);
						if (row.getCell(index1).getCellType() == CellType.NUMERIC) {
							for (int k = j + 1; k < rowCount + 1; k++) {
								Row row1=sheet.getRow(k);
								if (row.getCell(index1).getNumericCellValue() == row1.getCell(index1).getNumericCellValue()) {
									row2 = sheet.getRow(k);
									row3 = sheet.getRow(j);
							}
							
							}

						}
					}
					break;

				}

			}

		}
		System.out.println("Similar marks in maths is :" + row2.getCell(0).getStringCellValue()+" and "+row3.getCell(0).getStringCellValue());
		workbook.close();

	}

}
