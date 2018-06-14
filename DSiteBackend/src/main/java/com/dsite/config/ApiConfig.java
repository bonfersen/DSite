package com.dsite.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/***
 * Esta clase puede anadir beans definidos al contenedor en tiempo de ejecucion
 * 
 * @author Luis Bustamante
 *
 */
@Configuration
public class ApiConfig {

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean(name = "org.dozer.Mapper")
	public DozerBeanMapper dozerBean() {
		DozerBeanMapper dozerBean = new DozerBeanMapper();
		/*dozerBean.addMapping(new BeanMappingBuilder() {

			protected void configure() {
				mapping(Bean.class, Bean.class, TypeMappingOptions.mapNull(false));
			}
		});*/
		return dozerBean;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**").allowedOrigins("*").allowedMethods("POST", "GET", "OPTIONS", "DELETE")
						.allowedHeaders("header1", "header2", "header3").exposedHeaders("header1", "header2")
						.allowCredentials(false).maxAge(3600);
			}
		};
	}
}
