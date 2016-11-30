package com.osi.urm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
@ConfigurationProperties(prefix = "spring")
public class AppConfig {
	private String dbDateformat;

	public String getDbDateformat() {
		return dbDateformat;
	}

	public void setDbDateformat(String dbDateformat) {
		this.dbDateformat = dbDateformat;
	}
	
}
