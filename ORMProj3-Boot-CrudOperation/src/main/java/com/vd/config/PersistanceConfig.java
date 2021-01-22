package com.vd.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.vd.entity.Project;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.vd.dao")
public class PersistanceConfig {
	@Bean("hkds")
	public DataSource createDs() {
		HikariDataSource hkds=null;
		hkds=new HikariDataSource();
		hkds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hkds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hkds.setPassword("viodev");
		hkds.setUsername("System");
		hkds.setMaximumPoolSize(50);
		hkds.setMinimumIdle(10);
		return hkds;
	}
	@Bean("sesfact")
	public LocalSessionFactoryBean createSesFact() {
		Properties prop=null;
		LocalSessionFactoryBean factory= new LocalSessionFactoryBean();
		factory.setDataSource(createDs());
		factory.setAnnotatedClasses(Project.class);
		prop=new Properties();
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		prop.setProperty("show_sql", "true");
		prop.setProperty("format_sql", "true");
		prop.setProperty("hbm2ddl.auto", "update");
		factory.setHibernateProperties(prop);
		return factory;
	}
	@Bean
	public HibernateTemplate createHT() {
		return new HibernateTemplate(createSesFact().getObject());
	}
}
