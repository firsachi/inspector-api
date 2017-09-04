package ua.kiev.inspector_api.configurations;

import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import ua.kiev.inspector.model.configuration.AppConfigInspectorModel;


public class Initializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppMvcConfig.class);
		ctx.register(SecurituSpringConfig.class);
		ctx.register(AppConfigInspectorModel.class);
		servletContext.addListener(new ContextLoaderListener(ctx));
		ctx.setServletContext(servletContext);
		Dynamic servlet = servletContext.addServlet("appServlet", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
