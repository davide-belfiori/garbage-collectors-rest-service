package it.unicam.ids.garbageCollectors.config;

import org.springframework.core.env.Environment;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(2)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Environment env;
	
	private boolean isH2Enable() {
		return Arrays.asList(env.getActiveProfiles()).contains("h2");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/h2-console/**");
		if(isH2Enable()) {
			http.httpBasic().and()
				.authorizeRequests()
				.antMatchers("/h2-console/**").hasAnyRole("ADMIN")
				.and().formLogin();
			http.headers().frameOptions().disable();
			http.csrf().disable();
		}
	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		if(isH2Enable()) {
			auth.inMemoryAuthentication()
				.withUser("user")
				.password("{noop}user")
				.roles("ADMIN");
		}
	}

}
