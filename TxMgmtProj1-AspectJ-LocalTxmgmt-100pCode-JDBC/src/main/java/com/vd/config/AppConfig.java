package com.vd.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {PersistanceConfig.class,AOPConfig.class,ServiceConfig.class})
public class AppConfig {

}
