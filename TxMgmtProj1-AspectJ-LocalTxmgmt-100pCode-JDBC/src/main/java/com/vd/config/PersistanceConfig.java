package com.vd.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan("com.vd.dao")
public class PersistanceConfig {
	
	@Bean("hkds")
	public DataSource createDs() {
		HikariDataSource ds=null;
		ds=new HikariDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("System");
		ds.setPassword("viodev");
		ds.setMaximumPoolSize(20);
		ds.setMinimumIdle(10);
		return ds;
	}
	@Bean("template")
	public JdbcTemplate createJT() {
		return new JdbcTemplate(createDs());
	}
}
