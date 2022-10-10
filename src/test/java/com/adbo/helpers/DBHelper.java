 

package com.adbo.helpers;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component

public class DBHelper {

@Autowired
private World world;

public Accounts getSubAccountValue(String subAccount) throws IOException {

ApplicationContext context = new ClassPathXmlApplicationContext("sql/Bean.xm1") ;

AccountsJDBCTemplate accountsJDBCTemplate = (AccountsJDBCTemplate) context.getBean("accountsJDBCTemplate") ;

List<Accounts> accounts = accountsJDBCTemplate.listAccounts(world.testDataDto.getCinNumber() ,world.testDataDto.getAccountNumber()) ;
return accounts.stream().filter(p -> p.getSubAccountNo().toString() .equals(subAccount) ).collect(Collectors.toList()).get(0);
}}