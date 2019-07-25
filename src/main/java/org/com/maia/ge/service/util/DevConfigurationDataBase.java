package org.com.maia.ge.service.util;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfigurationDataBase {

	@Autowired
	private DBTestService dbTestService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instanciateTestDatabase() throws ParseException {
		if (!"create".equals(strategy)) {
			return false;
		} else {
			dbTestService.instanciateTestDatabase();
			return true;
		}
	}

}
