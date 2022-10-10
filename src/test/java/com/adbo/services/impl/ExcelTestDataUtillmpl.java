package com.adbo.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.adbo.World;
import com.adbo.domain.dto.adbo_coordinator.TestDataDto;
import com.adbo.services.InputOutputFileHandler;

@Service
@Qualifier("testDataService")
public class ExcelTestDataUtillmpl implements InputOutputFileHandler {

@Value("${rbs. overpayment .ExcelTestFilePath}")
private String excelTestDataFilePath;

@Autowired
private World world;

@Override
public Map<String, Object> readFile(String fileName) {
try {
boolean testdatafound = false;
Map<String, Object> testDataValues = new HashMap<>();
excelTestDataFilePath = String. format(excelTestDataFilePath, fileName);
FileInputStream file = new FileInputStream(new File(excelTestDataFilePath));

//Create Workbook instance holding reference to .xlsx file
XSSFWorkbook workbook = new XSSFWorkbook(file) ;

//Get first/desired sheet from the workbook
XSSFSheet sheet = workbook.getSheetAt(0) ;

TestDataDto testDataObject = new TestDataDto();
for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
Row row = sheet.getRow(i);
if (row.getCell(0).getStringCellValue().equals(world.dataTypeTag)) {
testDataObject. setDataType(row.getCell(0).getStringCellValue());
testDataObject. setAccountNumber(row.getCell(1).getStringCellValue());
testDataObject. setCinNumber(row.getCell(2).getStringCellValue());
testDataObject.setSubAccountPayment1 (row. getCell(3).getStringCellValue());
testDataObject. setSubAccountPayment2(row.getCell(4).getStringCellValue());
testDataValues.put(testDataObject.getDataType(), testDataObject);
}
}

if (testDataObject.getAccountNumber() == null)
	
	throw new Exception("test scenario id not found in input excel sheet");
return testDataValues;
}catch(Exception e) {
	e.printStackTrace();
	return null;
}}
}