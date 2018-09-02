package forBlog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.ObjectMapper;

import generic.GeneralCode;

public class Part1 {
	public static void main(String args[]) throws IOException {
		
		
		byte[] json = Files.readAllBytes(Paths.get("testPart1.json"));

		ObjectMapper mapper = new ObjectMapper();
		List<TestJson> myObjects = Arrays.asList(mapper.readValue(json, TestJson[].class));
		
		String[] myHeaders = {"First Name","Last Name","Occupation","City"};
		int sheetRowCount = 0;
		
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("FirstSheet");
		Row row = sheet.createRow(sheetRowCount++);
		Cell cell= null;
		
		int cellCounter = 0;
		for(String key: myHeaders) {
			cell = row.createCell(cellCounter);
			cell.setCellValue(myHeaders[cellCounter++]);
			cell.setCellStyle(GeneralCode.getBorderedCellStyle(wb, BorderStyle.THICK));
		}
		cellCounter = 0;
		
		int numRows = myObjects.size();
		
		for(int i=0; i<numRows;i++) {
			row = sheet.createRow(sheetRowCount++);
			TestJson currentObject = myObjects.get(i);
			cellCounter = 0;
			for(String key: myHeaders) {
				cell = row.createCell(cellCounter);
				cell.setCellValue(currentObject.getData(myHeaders[cellCounter++]));
				cell.setCellStyle(GeneralCode.getBorderedCellStyleWithBackground(wb, BorderStyle.HAIR, IndexedColors.AQUA.getIndex(), FillPatternType.SOLID_FOREGROUND, IndexedColors.BLACK.getIndex()));
			}
		}
		
		sheet.addMergedRegion(new CellRangeAddress(5,10,6,11));
		
		row = (sheet.getRow(5)==null)?(sheet.createRow(5)):(sheet.getRow(5));
		cell = (row.getCell(6)==null)?(row.createCell(6)):(row.getCell(6));
		
		cell.setCellValue("THIS IS MERGERD REGION");
		
		//=====CODE FOR AUTOSIZING COLUMNS=====
		for(int i=0; i< myHeaders.length; i++)
			sheet.autoSizeColumn(i);
		FileOutputStream fileOut = new FileOutputStream("BlogDemo.xlsx");
		wb.write(fileOut);
		fileOut.close();
	
		
		if(wb!=null)
			wb.close();
		System.out.println("Done!");
	}
}
