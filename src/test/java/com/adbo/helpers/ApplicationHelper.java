package com.adbo.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.adbo.domain.json.adbo_transformation_coordinator.security.AuthenticationRequestDto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component

public class ApplicationHelper {

	private final Logger logger = LoggerFactory.getLogger(ApplicationHelper.class);

	@Autowired
	@Qualifier("infoTipService")
	private InputOutputFileHandler infoTipFileService;

	@Autowired
	@Qualifier("testDataService")
	private InputOutputFileHandler testDataService;

	@Autowired
	private TokenCreator tokenCreator;

	@Autowired
	private EncrypterDecrypter decryptedValue;

public Map<String,Object> getTooltipValue(String fileName) {

return infoTipFileService.readFile(fileName) ;

	public Map<String, Object> getTooltipValue(String fileName) {
		return infoTipFileService.readFile(fileName);
	}

	public Map<String, Object> getTestDataObject(String fileName) {
		return testDataService.readFile(fileName);
	}

public static String[] toolTipMessages = new String[10@];
	public static HashMap<String, String> tooltipMessages = new HashMap<String, String>();

	private static final Logger log = LoggerFactory.getLogger(ExcelUtility.class);

public void readTextFile(String textFile) {

BufferedReader br = null;
int arraycount=1;

try {

String sCurrentLine;
String textFileLocation = "\\input\\TextFiles\\%s.txt";

String iFile = System.getProperty("user.dir")+String. format (textFileLocation, textFile) ;
br = new BufferedReader(new FileReader(iFile));

while ((sCurrentLine = br.readLine()) != null) {
toolTipMessages[arraycount] = sCurrentLine;
arraycount = arraycount+1;
String[] textvalues = sCurrentLine.split("=");
tooltipMessages.put(textvalues[@], textvalues[1]);
}	

} catch (IOException e) {
e.printStackTrace();
} finally {
try {
if (br != null)br.close();
} catch (IOException ex) {
ex.printStackTrace()}
}

}

	public String getToken(AuthenticationRequestDto authenticationRequestDto) throws IOException {
		return tokenCreator.getBearerToken(authenticationRequestDto);
	}

	public String getDecryptedString(String encryptedKey) {
		return decryptedValue.decrypt(encryptedKey);
	}
}
