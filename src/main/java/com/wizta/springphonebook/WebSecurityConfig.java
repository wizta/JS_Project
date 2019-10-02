package com.wizta.springphonebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf()
		.disable()
		
		.authorizeRequests()
		.antMatchers("/guest**")
		.hasAuthority("USER")
		.antMatchers("/phonebook/**").hasAuthority("ADMIN")
		.antMatchers("/api/**").hasAuthority("ADMIN")
		
		.anyRequest()
		.fullyAuthenticated()
		.and()
		.httpBasic()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.logoutSuccessUrl("/login")
		//Add .deleteCookies for resolve can't rest on POSTMAN.
		.deleteCookies("JSESSIONID")
		.permitAll();
		 
		 
	}
	
	@SuppressWarnings("deprecation")
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 auth.userDetailsService(userService);
		 auth.userDetailsService(userService)
		 .passwordEncoder(NoOpPasswordEncoder.getInstance());
		 */

		auth.inMemoryAuthentication()
		.passwordEncoder(NoOpPasswordEncoder.getInstance())
        .withUser("admin1")
        .password("1q2w3e4r")
        .roles("ADMIN")
        .authorities("ADMIN")
        .and()
        .withUser("guest")
        .password("guest")
        //.password(encoder()
        //.encode("guest"))
        .roles("USER")
        .authorities("USER");
		
		/*working but not pass when we try to call rest service on postman
		auth.inMemoryAuthentication()
				.passwordEncoder(NoOpPasswordEncoder.getInstance())
				.withUser("admin")
				.password("1q2w3e4r")
				.roles("ADMIN")
				.authorities("ADMIN");
		*/

	}
	
	@Bean
	public PasswordEncoder  encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

}