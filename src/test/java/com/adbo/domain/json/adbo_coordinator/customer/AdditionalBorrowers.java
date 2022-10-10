package com.adbo.domain.json.adbo_coordinator.customer;

import java.util.ArrayList;
import java.util.List;

public class AdditionalBorrowers {
	private String forename;

	private String surname;

	private String dateOfBirth;

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getForename() {
		return this.forename;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfBirth() {
		return this.dateOfBirth;
	}
}