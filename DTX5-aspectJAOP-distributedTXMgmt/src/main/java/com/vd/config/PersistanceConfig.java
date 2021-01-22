package com.vd.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
public class PersistanceConfig {
	@Bean("oraDs")
	public AtomikosDataSourceBean createOraDs() {
		AtomikosDataSourceBean ds=null;
		Properties prop=null;
		
		ds=new AtomikosDataSourceBean();
		ds.setUniqueResourceName("OraXADS");
		ds.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
		prop=new Properties();
		prop.setProperty("databaseName", "xe");
		prop.setProperty("user", "System");
		prop.setProperty("password", "viodev");
		prop.setProperty("URL", "jdbc:oracle:thin:@localhost:1521:xe");
		ds.setXaProperties(prop);
		return ds;
		
	}
	@Bean("mysqlXADs")
	public AtomikosDataSourceBean createMySqlDs() {
		AtomikosDataSourceBean ds=null;
		Properties prop=null;
		
		ds=new AtomikosDataSourceBean();
		ds.setUniqueResourceName("MySqlXADS");
		ds.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
		prop=new Properties();
		prop.setProperty("databaseName", "springdb");
		prop.setProperty("user", "root");
		prop.setProperty("password", "viodev");
		prop.setProperty("URL", "jdbc:mysql:///springdb");
		ds.setXaProperties(prop);
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
