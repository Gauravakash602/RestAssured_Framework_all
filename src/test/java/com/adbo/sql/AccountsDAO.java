package com.adbo.sql;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
public interface AccountsDAO {

public void setDataSource(DataSource ds);
public List<com.adbo.sql.Accounts> listAccounts(String cin, String accountNumber) throws IOException;
}