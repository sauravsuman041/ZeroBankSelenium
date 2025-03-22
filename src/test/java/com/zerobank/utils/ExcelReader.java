package com.zerobank.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {
    public static List<List<String>> readExcelData(String filePath) {
        List<List<String>> data = new ArrayList<>();
        
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            
//            System.out.println(sheet.getLastRowNum());
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                List<String> rowData = new ArrayList<>();
                for (Cell cell : row) {
                    rowData.add(cell.toString());
                }
                data.add(rowData);
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

//    public static void updateFeatureFileWithData(String excelPath, String featurePath) {
//        List<List<String>> data = readExcelData(excelPath);
//        
//        StringBuilder featureContent = new StringBuilder();
//        featureContent.append(
//                        "Feature: Login Feature\r\n\n"
//                        + "  Scenario Outline: User Login \r\n"
//                        + "    Given The user is on the home page\r\n"
//                        + "    When User enter the login credentials \"<username>\" and \"<password>\"\r\n"
//                        + "    Then Validate user login successfully\r\n\n"
//                        + "    Examples: \n"
//        );
//
//        for (int i = 0; i < data.size(); i++) {
//            featureContent.append("      | ")
//                    .append(data.get(i).get(0)).append(" | ")
//                    .append(data.get(i).get(1)).append(" |\n");
//        }
//
//        try (FileWriter writer = new FileWriter(featurePath)) {
//            writer.write(featureContent.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    public static void updateFeatureFileWithData(String excelPath, String featurePath) {
        List<List<String>> data = readExcelData(excelPath);

        try {
            // Read the existing feature file content
            List<String> lines = Files.readAllLines(Paths.get(featurePath));
            StringBuilder newFeatureContent = new StringBuilder();

            boolean insideExamples = false;

            for (String line : lines) {
                if (line.trim().startsWith("Examples:")) {
                    insideExamples = true;
                    newFeatureContent.append(line).append("\n"); // Retain "Examples:"
                    break; 
                }
                newFeatureContent.append(line).append("\n");
            }

            // Append new examples from Excel
            for (int i = 0; i < data.size(); i++) { 
            	newFeatureContent.append("      | ");
            	for(int j=0;j<data.get(0).size();j++) {
//            		System.out.println(data.get(i).get(j));
            		newFeatureContent.append(data.get(i).get(j)).append(" | ");
            	}
            	newFeatureContent.append(" \n");
            	System.out.println();
            }

            // Write back to the feature file
            Files.write(Paths.get(featurePath), newFeatureContent.toString().getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    
}