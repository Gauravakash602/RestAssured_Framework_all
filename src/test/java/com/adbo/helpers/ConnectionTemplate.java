package com.adbo.helpers;

import com.adbo.*;

import org.aspectj.weaver.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ConnectionTemplate {

	@Autowired
	World world;

	@Autowired
	@Qualifier("rbs-accounts-template")
	JdbcTemplate rbsAccountsTemplate;

	@Autowired
	@Qualifier("nwb-accounts-template")
	JdbcTemplate nwbAccountsTemplate;

	@Autowired
	@Qualifier("rbs-payments-template")
	JdbcTemplate rbsPaymentsTemplate;

	@Autowired
	@Qualifier("nwb-payments-template")
	JdbcTemplate nwbPaymentsTemplate;

public JdbcTemplate getPaymentsJDBCTemplateForBrand(){
String brand = Optional.of(world.brand) .orElse("nwb");
switch(brand.toLowerCase()){
case "rbs":
return this.rbsPaymentsTemplate;
default:
return this.nwbPaymentsTemplate;}}

public JdbcTemplate getAccountsJDBCTemplateForBrand(){
String brand = Optional.of(world.brand).orElse("nwb");
switch(brand.toLowerCase()){
case "rbs":
return this.rbsAccountsTemplate;
default:
return this.nwbAccountsTemplate;

}}

	public JdbcTemplate getRbsAccountsTemplate() {
		return rbsAccountsTemplate;
	}

	public void setRbsAccountsTemplate(JdbcTemplate rbsAccountsTemplate) {
		this.rbsAccountsTemplate = rbsAccountsTemplate;
	}

	public JdbcTemplate getNwbAccountsTemplate() {
		return nwbAccountsTemplate;
	}

	public void setNwbAccountsTemplate(JdbcTemplate nwbAccountsTemplate) {
		this.nwbAccountsTemplate = nwbAccountsTemplate;
	}

	public JdbcTemplate getRbsPaymentsTemplate() {
		return rbsPaymentsTemplate;
	}

	public void setRbsPaymentsTemplate(JdbcTemplate rbsPaymentsTemplate) {
		this.rbsPaymentsTemplate = rbsPaymentsTemplate;
	}

	public JdbcTemplate getNwbPaymentsTemplate() {
		return nwbPaymentsTemplate;
	}

	public void setNwbPaymentsTemplate(JdbcTemplate nwbPaymentsTemplate) {
		this.nwbPaymentsTemplate = nwbPaymentsTemplate;
	}
}
