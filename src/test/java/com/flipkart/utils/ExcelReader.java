package com.flipkart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

    // This method reads the Excel sheet and returns a List of Maps
    // Each Map represents a ROW in Excel (Key=Header, Value=Cell Data)
    public static List<Map<String, String>> getData(String excelFilePath, String sheetName) throws IOException {
        
        // 1. Open the file
        File file = new File(excelFilePath);
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        // 2. Get the Header Row (Row 0)
        Row headerRow = sheet.getRow(0);
        List<String> headers = new ArrayList<>();
        for (Cell cell : headerRow) {
            headers.add(cell.toString());
        }

        // 3. Loop through the data rows (starting from Row 1)
        List<Map<String, String>> dataList = new ArrayList<>();
        int rowCount = sheet.getLastRowNum();

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue; // Skip empty rows

            // Create a Map for this specific row
            Map<String, String> rowMap = new LinkedHashMap<>();

            for (int j = 0; j < headers.size(); j++) {
                Cell cell = row.getCell(j);
                // Handle empty cells
                String value = (cell != null) ? cell.toString() : ""; 
                rowMap.put(headers.get(j), value);
            }
            dataList.add(rowMap);
        }

        workbook.close();
        fis.close();
        return dataList;
    }
}