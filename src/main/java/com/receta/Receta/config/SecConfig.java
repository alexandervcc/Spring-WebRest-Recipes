package com.receta.Receta.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@AllArgsConstructor
@Configuration
public class SecConfig  extends WebSecurityConfigurerAdapter {

	private JWTAuthorizationFilter jwtAuthorizationFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.httpBasic().disable()
			.formLogin().disable()
			.addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
                        .antMatchers(HttpMethod.GET, "/users").permitAll()
                        .antMatchers(HttpMethod.POST, "/registerUser").permitAll()
                        .antMatchers(HttpMethod.POST, "/login").permitAll()                                
                        .antMatchers(HttpMethod.GET, "/recetas").permitAll()
                        .antMatchers(HttpMethod.GET, "/buscarReceta").permitAll()
                        .antMatchers(HttpMethod.GET, "/receta").permitAll()     
                        .antMatchers(HttpMethod.GET, "/ingredientes").permitAll()     
                        .antMatchers(HttpMethod.GET, "/pasos").permitAll()
                        .antMatchers(HttpMethod.GET, "/usuarios").permitAll()
						.antMatchers(HttpMethod.GET,"/confirm/**").permitAll()
				.anyRequest().authenticated()
		;

	}
}
