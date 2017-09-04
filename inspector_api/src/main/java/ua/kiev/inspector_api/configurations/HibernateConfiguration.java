package ua.kiev.inspector_api.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ua.kiev.inspector.model.dao.DaoFactory;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	
	@Bean
	public DaoFactory daoFactory() {
		DaoFactory factory = DaoFactory.getInstance();
		return factory;
	}

}
