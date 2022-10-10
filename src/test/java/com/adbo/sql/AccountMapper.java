 

package com.adbo.sql;
import org. springframework. jdbc. core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Accounts> {

@Override
public com.adbo.sql.Accounts mapRow(ResultSet resultSet, int i) throws SQLException {
Accounts account = new Accounts();
account. setSubAccountNo(resultSet.getInt("ACCL_SUBACC_NO"));
account. setCurrentBanlance(resultSet. getDouble("CURRENT_BALANCE") ) ;
account. setInterestRate(resultSet.getDouble("ACC_INTR_GROSS_RATE"));
account. setAccountType(resultSet. getString("VT_DESC"));
account. setTermMonths (resultSet. getInt("ACC_MONTHS"));
return account;
}}