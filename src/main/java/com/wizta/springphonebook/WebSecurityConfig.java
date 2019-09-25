package com.wizta.springphonebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
		.disable()
	.authorizeRequests()
		.antMatchers("/phonebook/**").hasAuthority("ADMIN")
		.antMatchers("/api/**").hasAuthority("ADMIN")
		.anyRequest().fullyAuthenticated()
		.and()
	.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
	.logout()
		.logoutSuccessUrl("/login")
		.permitAll();

	}

	
	@SuppressWarnings("deprecation")
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		//auth.userDetailsService(userService);
		/*
		 * auth.userDetailsService(userService)
		 * .passwordEncoder(NoOpPasswordEncoder.getInstance());
		 */
		
		auth
		.inMemoryAuthentication()
			.passwordEncoder(NoOpPasswordEncoder.getInstance())
			.withUser("admin")
			.password("1q2w3e4r")
			.roles("ADMIN")
			.authorities("ADMIN");

	}
	/*		
		.and()
			.withUser("john")
			.password("{noop}password")
			.roles("USER")
			.authorities("USER");
			
	}*/
	/*
	 * @Bean
	 * 
	 * @Override public UserDetailsService userDetailsService() {
	 * 
	 * @SuppressWarnings("deprecation") UserDetails user =
	 * User.withDefaultPasswordEncoder() .username("admin") .password("1q2w3e4r")
	 * .roles("ADMIN") .authorities("ADMIN") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user); }
	 */

}