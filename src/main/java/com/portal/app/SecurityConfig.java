package com.portal.app;

import static com.portal.app.util.Constants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig
{
	@Value("${app.user}")				private String appUser;
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception 
	{
		for (String user : appUser.split(",")) 
		{
			String userId = user.split("@")[0];
			String password = user.split("@")[1].split(":")[0];
			String role = user.split("@")[1].split(":")[1];
			auth.inMemoryAuthentication().withUser(userId).password("{noop}"+password).roles(role);
		}
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
	{
		return http
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
			.and().authorizeRequests(authorize -> authorize
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.antMatchers("/service/**").hasRole(APPLICATION))
			.headers().frameOptions().disable()
			.and()
			.httpBasic()
			.and()
			.build();
	}
}

