package com.receta.Receta;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class RecetaApplication {

   
    //Punto de arranque de la aplicacion
	public static void main(String[] args) {
		SpringApplication.run(RecetaApplication.class, args);
	}

	//Configuraciones adicionales
	@Bean
    ModelMapper modelMapper() {
            return new ModelMapper();
    }  
    
	//Indicar que en la configuracion se hara para la seguridad
    @EnableWebSecurity
    //Indicar que se realizara una configuracion
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			//Anadiendo seguridad de filtrado a los endpoitns
			//desactiovar la protecion csrf
			http.csrf().disable()
				//Anadir un filtro a la cadena de filtros -> Componente de Seguridad para JWT
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				//Dandelo authorizations alos endpounts
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
				.anyRequest().authenticated();
		}
	}
	
}
