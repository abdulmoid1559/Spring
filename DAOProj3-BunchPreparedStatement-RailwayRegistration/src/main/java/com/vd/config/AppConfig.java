package com.vd.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.vd")
public class AppConfig {
	@Bean("hkds")
	public DataSource getHikariDataSource() {
		HikariDataSource ds=new HikariDataSource();
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUsername("System");
		ds.setPassword("viodev");
		ds.setConnectionTimeout(300l);
		ds.setIdleTimeout(200l);
		return ds;
	}
	@Bean("template")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(this.getHikariDataSource());
		return template;	
	}
}
