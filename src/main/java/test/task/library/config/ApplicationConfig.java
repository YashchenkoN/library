package test.task.library.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import test.task.library.Application;

import static org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScan(
		basePackageClasses = {Application.class},
		excludeFilters = @Filter({
				Controller.class, Configuration.class, ControllerAdvice.class, RestController.class
		})
)
class ApplicationConfig {
	
	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setIgnoreUnresolvablePlaceholders(true);
		ppc.setLocation(new ClassPathResource("settings.properties"));
		return ppc;
	}
	
}