package com.vd.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class AOPConfig {
	@Autowired
	private DataSource ds;
	
	@Bean("manager")
	public DataSourceTransactionManager createManager() {
		return new DataSourceTransactionManager(ds);
	}
}
