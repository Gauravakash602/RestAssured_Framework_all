package com.adbo.domain.dto.adbo_coordinator.mapper;

import com.adbo.domain.dto.adbo_coordinator.MortgageAccountDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MortgageAccountsDetailsMapper implements RowMapper<MortgageAccountDetails> {
	@Override
	public MortgageAccountDetails mapRow(ResultSet resultSet, int i) throws SQLException {
		MortgageAccountDetails details = new MortgageAccountDetails();
		details.setAccountNumber(resultSet.getString("acc_account_no"));
		details.setSequenceNumber(resultSet.getInt("acc_soc_seqno"));
		details.setSubAccountNumber(resultSet.getString("acc_subacc_no"));
		details.setCurrentBalance(resultSet.getDouble("current_balance"));
		details.setInterestRate(resultSet.getDouble("acc_intr_gross_rate"));
		details.setInterestType(resultSet.getString("intc_short_name"));
		details.setInterestTypeDescription(resultSet.getString("intr_type_desc"));
		details.setMonthlyPayment(resultSet.getDouble("paye_reg_amount"));
		details.setRepaymentType(resultSet.getString("repayment_type_desc"));
		details.setLastValuationAmount(resultSet.getDouble("prop_valuation"));
		details.setLastValuationDate(resultSet.getString("prop_valuation_date"));
		details.setMonthlyPaymentDueDate(resultSet.getString("paye_next_due_date"));
		details.setTermEndDate(resultSet.getString("acc_sched_term_date"));
		details.setBuyToLet(resultSet.getString("prodresinv"));
		return details;

	}
}