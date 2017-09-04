package ua.kiev.inspector_api.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurituSpringConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private AuthenticationProvider inspectorAuthenticationProvider;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(inspectorAuthenticationProvider);
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.exceptionHandling()
			.and().authorizeRequests()
			.antMatchers("/api/**").hasAuthority("USER")
			.and()
			.formLogin()
			.and()
			.logout();
	}

}
