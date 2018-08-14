package com.bianjp.spring.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
@ImportResource("classpath:test.xml")
public class Application {

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
    configurer.setLocations(resolver.getResource("classpath:config/test.properties"));
    return configurer;
  }

  public static void main(String[] args) {
    // Comment/uncomment the line to see whether system properties have higher precedence
    System.setProperty("test.origin", "System Properties");
    SpringApplication.run(Application.class, args);
  }
}
