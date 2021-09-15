
package br.com.conquer.marcus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter { 

	
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		http.cors(); 
		http.csrf().disable(); 
		  http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and  
		 ().httpBasic(); 
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("conquer").password("{noop}conquer123").roles("USER");// roles(papel do usuario), {noop}: usado para codificar senhas,DelegatingPassword, Encoder use , NoOpPasswordEnco: validando minha senha, cada um tem sua ação
	}

}

	 


