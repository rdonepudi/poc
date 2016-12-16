package com.osi.urm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
@ConfigurationProperties(prefix = "spring")
public class AppConfig {
	public static final String AUTH_TOKEN="Auth_Token";
	public static final long TOKEN_CLEAR_TIME_IN_MS=300000L;
	private String dbDateformat;
	private String tokenExpTimeInSecs;

	public String getDbDateformat() {
		return dbDateformat;
	}

	public void setDbDateformat(String dbDateformat) {
		this.dbDateformat = dbDateformat;
	}

	public String getTokenExpTimeInSecs() {
		return tokenExpTimeInSecs;
	}

	public void setTokenExpTimeInSecs(String tokenExpTimeInSecs) {
		this.tokenExpTimeInSecs = tokenExpTimeInSecs;
	}

}
