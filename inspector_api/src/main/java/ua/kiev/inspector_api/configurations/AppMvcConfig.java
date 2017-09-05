package ua.kiev.inspector_api.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.gson.Gson;


@Configuration
@ComponentScan("ua.kiev.inspector_api.")
@EnableWebMvc
public class AppMvcConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public Gson startGson() {
		return new Gson();
	}
	
}
