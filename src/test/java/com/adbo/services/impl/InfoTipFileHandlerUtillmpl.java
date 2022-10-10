
package com.adbo.services.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.adbo.services.InputOutputFileHandler;

@Service
@Qualifier("infoTipService")
public class InfoTipFileHandlerUtillmpl implements InputOutputFileHandler {

	@Value("${infotip. overpayment. testfile}")
	private String infoTipFileLoc;

	@Override
	public Map<String, Object> readFile(String fileName) {
		BufferedReader bufferedReader = null;
		String sCurrentLine;
		Map<String, Object> findInfoTipText = new HashMap<>();
		try {
			String infoTipFileLocation = String.format(infoTipFileLoc, fileName);

			bufferedReader = new BufferedReader(new FileReader(infoTipFileLocation));

			while ((sCurrentLine = bufferedReader.readLine()) != null) {
				String[] split = sCurrentLine.split("=");
				findInfoTipText.put(split[0], split[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}

		return findInfoTipText;
	}
}