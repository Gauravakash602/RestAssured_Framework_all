 

package com.adbo.helpers;

import org. springframework.beans. factory. annotation. Qualifier;

import org. springframework.boot . context . properties .ConfigurationProperties;
import org. springframework. boot. jdbc.DataSourceBuilder;

import org. springframework.context.annotation.Bean;

import org. springframework. context. annotation.Configuration;

import org. springframework. jdbc. core. JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

@Bean(name="rbs-accounts-source")
@ConfigurationProperties (prefix = "spring.datasource.rbs.accounts")
public DataSource rbsAccountsDataSource(){
return DataSourceBuilder.create().build();
}

@Bean(name = "rbs-accounts-template")

public JdbcTemplate rbsAccountsTemplate(@Qualifier("rbs-accounts-source")DataSource dataSource){
return new JdbcTemplate(dataSource) ;

}

@Bean(name="nwb-accounts-source")
@ConfigurationProperties (prefix = "spring.datasource.nwb.accounts")
public DataSource nwbAccountsDataSource(){
return DataSourceBuilder.create().build();
}

@Bean(name = "nwb-accounts-template")

public JdbcTemplate nwbAccountsTemplate(@Qualifier("nwb-accounts-source")DataSource dataSource){
return new JdbcTemplate(dataSource) ;

}

@Bean(name="rbs-payments-source")
@ConfigurationProperties(prefix = "spring.datasource.rbs.payments")
public DataSource rbsPaymentsDataSource(){
return DataSourceBuilder.create().build();
}
}