package com.adbo.domain.dto.adbo_coordinator.mapper;

import com.adbo.domain.dto.adbo_coordinator.CustomerDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDetailsMapper implements RowMapper<CustomerDetails> {

	@Override

	public CustomerDetails mapRow(ResultSet resultSet, int i) throws SQLException {
		CustomerDetails details = new CustomerDetails();
		details.setForename(resultSet.getString("cust_forenames_first"));
		details.setSurname(resultSet.getString("cust_surname"));
		details.setEmail(resultSet.getString("cust_email_address"));
		details.setMobileNumber(resultSet.getString("cust_mobile_telephone"));
		return details;
	}
}