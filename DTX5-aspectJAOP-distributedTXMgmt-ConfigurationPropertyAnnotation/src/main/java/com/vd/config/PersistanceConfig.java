package com.vd.config;

import java.util.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
public class PersistanceConfig {
	@Bean("oraDs")
	@ConfigurationProperties("tx.xa.orads")
	public AtomikosDataSourceBean createOraDs() {
		AtomikosDataSourceBean ds=null;
		
		ds=new AtomikosDataSourceBean();
		return ds;
		
	}
	@Bean("mysqlXADs")
	@ConfigurationProperties("tx.xa.mysqlds")
	public AtomikosDataSourceBean createMySqlDs() {
		AtomikosDataSourceBean ds=null;
		
		ds=new AtomikosDataSourceBean();
		return ds;
	}
	@Bean("orajt")
	public JdbcTemplate createOraJt() {
		return new JdbcTemplate(createOraDs());
	}
	@Bean("mysqlJT")
	public JdbcTemplate createMysqlJt() {
		return new JdbcTemplate(createMySqlDs());
	}
}
