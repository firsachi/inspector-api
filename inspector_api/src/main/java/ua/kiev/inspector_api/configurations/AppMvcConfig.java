package ua.kiev.inspector_api.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan("ua.kiev.inspector_api.")
@EnableWebMvc
public class AppMvcConfig extends WebMvcConfigurerAdapter{
	
}
