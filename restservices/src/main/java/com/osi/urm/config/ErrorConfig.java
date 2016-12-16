package com.osi.urm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("errorOrSuccessMsg.properties")
public class ErrorConfig {
	@Autowired
	private Environment env;
}
