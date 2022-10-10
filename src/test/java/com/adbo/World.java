package com.adbo;


import com.adbo.domain.dto.adbo_coordinator.TestDataDto;
import com.adbo.domain.json.adbo_coordinator.accounts .AccountsSummary ;
import com.adbo.model.SearchModelDto;
import io.cucumber.java.Scenario;
import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
public class World {
public TestDataDto testDataDto;
public String brand;
public Scenario scenario;
public String accessToken;
public AccountsSummary accountsSummary;
public Boolean bsFlag = false;
public Boolean isExcelDataNeeded = false;
public String dataTypeTag;

public SearchModelDto searchValue;

public void setIsExcelDataNeeded(boolean b) {
	// TODO Auto-generated method stub
	
}

public boolean getIsExcelDataNeeded() {
	// TODO Auto-generated method stub
	return false;
}


	
}
