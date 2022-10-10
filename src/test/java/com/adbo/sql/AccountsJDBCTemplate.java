package com.adbo.sql;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;




@Component
public abstract class AccountsJDBCTemplate implements AccountsDAO{

private DataSource dataSource;
private JdbcTemplate jdbcTemplateObject;

public void setDataSource(DataSource dataSource) {
this.dataSource = dataSource;
this. jdbcTemplateObject = new JdbcTemplate(dataSource) ;
}
public List<Accounts> ListAccounts(String cin, String accountNumber) throws IOException {
String iFile = System.getProperty("user.dir")+"\\src\\test\\resources\\sql\\accounts.sql";
BufferedReader br = new BufferedReader(new FileReader(iFile));
StringBuilder sb = new StringBuilder();
String line;
while ((line = br.readLine()) != null)
sb.append(line) ;

String SQL = String. format(sb.toString(),accountNumber, cin);
List <Accounts> accounts = jdbcTemplateObject.query(SQL, new AccountMapper());
return accounts;
}

}