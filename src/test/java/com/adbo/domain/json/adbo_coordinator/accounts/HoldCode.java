package com.adbo.domain.json.adbo_coordinator.accounts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.Assert;

import java.util.List;
import java.util.function.Supplier;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HoldCode
{
    private String EXT;

    private String CMSGC;

    private String COLL;

    private String LMS;

    private String RECOV;

    private String SCQC;

    private String ARRARR;

    private String PACCP;
    
    
    
    public String getMMOTR() {
		return MMOTR;
	}
	public void setMMOTR(String mMOTR) {
		MMOTR = mMOTR;
	}
	public String getCOMPL() {
		return COMPL;
	}
	public void setCOMPL(String cOMPL) {
		COMPL = cOMPL;
	}
	public String getMMM() {
		return MMM;
	}
	public void setMMM(String mMM) {
		MMM = mMM;
	}
	public String getRBC() {
		return RBC;
	}
	public void setRBC(String rBC) {
		RBC = rBC;
	}
	private String MMOTR;

    private String COMPL;

    private String MMM;

    private String RBC;
    

    public void setEXT(String EXT){
        this.EXT = EXT;
    }
    public String getEXT(){
        return this.EXT;
    }
    public void setCMSGC(String CMSGC){
        this.CMSGC = CMSGC;
    }
    public String getCMSGC(){
        return this.CMSGC;
    }
    public void setCOLL(String COLL){
        this.COLL = COLL;
    }
    public String getCOLL(){
        return this.COLL;
    }
    public void setLMS(String LMS){
        this.LMS = LMS;
    }
    public String getLMS(){
        return this.LMS;
    }
    public void setRECOV(String RECOV){
        this.RECOV = RECOV;
    }
    public String getRECOV(){
        return this.RECOV;
    }
    public void setSCQC(String SCQC){
        this.SCQC = SCQC;
    }
    public String getSCQC(){
        return this.SCQC;
    }
    public void setARRARR(String ARRARR){
        this.ARRARR = ARRARR;
    }
    public String getARRARR(){
        return this.ARRARR;
    }
    public void setPACCP(String PACCP){
        this.PACCP = PACCP;
    }
    public String getPACCP(){
        return this.PACCP;
    }
}
