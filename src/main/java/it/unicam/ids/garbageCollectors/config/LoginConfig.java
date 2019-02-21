package it.unicam.ids.garbageCollectors.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class LoginConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private Environment env;
	
	private boolean isH2Enable() {
		return Arrays.asList(env.getActiveProfiles()).contains("h2");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/login");
		if(isH2Enable())
			http.formLogin();
	}

	
}
