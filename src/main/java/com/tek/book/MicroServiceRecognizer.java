/**
 * 
 */
package com.tek.book;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Vinoth
 *
 */
@EntityScan("com.tek.book")
@EnableJpaRepositories("com.tek.book.ebook")
@SpringBootApplication
public class MicroServiceRecognizer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceRecognizer.class, args);
	}

	@Bean
	@ConfigurationProperties(prefix = "datasource.db-ebook")
	public DataSource eRFIDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public JdbcTemplate erfiJdbcTemplate() {
		return new JdbcTemplate(eRFIDataSource());
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
		rb.setBasenames(new String[] { "application", "locale/messages" });
		return rb;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*");
			}
		};
	}
}
