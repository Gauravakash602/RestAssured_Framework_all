 

package com.adbo.helpers;

//import javafx.scene.control.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel .XSSFWorkbook;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.adbo.model.SearchModelDto;

import java.io.*;

@Component
public class ExcelUtility {

@Value("${rbs. overpayment. ExcelTestFilePath}")
private String excelFilePath;

@Value("${rbs. overpayment .ExcelSheetName}")
private String excelSheetName;

private static final Logger log = LoggerFactory.getLogger(ExcelUtility. class);

public SearchModelDto mortgagePaymentTestData(String tagValue) {
try
{
boolean testdatafound = false;
FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")
+ excelFilePath));

//Create Workbook instance holding reference to .xlsx file
XSSFWorkbook workbook = new XSSFWorkbook(file) ;

//Get first/desired sheet from the workbook
XSSFSheet sheet = workbook.getSheet(excelSheetName) ;
SearchModelDto testDataObject = new SearchModelDto() ;






for(int i=sheet.getFirstRowNum();i<=sheet.getLastRowNum();i++) {
Row ro=sheet.getRow(i);
for(int j=ro.getFirstCellNum();j<ro.getLastCellNum();j++) {

Cell ce = ro.getCell(j);



if (j == 0)

testDataObject. setDataType(ce.getStringCellValue());
if (j == 1)

testDataObject. setAccountNumber(ce.getStringCellValue()) ;
if (j == 2)

testDataObject. setCinNumber(ce. getStringCellValue());
if (j == 3)

testDataObject. setChannel (ce. getStringCellValue());
if (j == 4)

testDataObject. setScope(ce.getStringCellValue()) ;
if (j == 5)

testDataObject. setDetails(ce.getStringCellValue());

if (j == 6)
testDataObject.setSubAccountPayment1(ce.getStringCellValue());

if(j == 7)
testDataObject.setSubAccountPayment2(ce.getStringCellValue());

if (j == 8)
testDataObject.setCurrentmonthlyPayment(ce.getStringCellValue());

if (j == 9)
testDataObject.setContinuedMonthlyPayment (ce. getStringCellValue());

if (j == 10)
testDataObject.setCurrentMortgageBalance(ce.getStringCellValue());

if (j == 11)

testDataObject.setNewEstimatedBalance(ce.getStringCellValue());

if (ce.getStringCellValue().equals(tagValue))
testdatafound = true;


testdatafound = true;
}
if(testdatafound)
break;
}
file.close();
return testDataObject;
}
catch (Exception e)
{	
e.printStackTrace();
return null;}
}}
