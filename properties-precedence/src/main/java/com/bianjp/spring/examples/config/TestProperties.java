package com.bianjp.spring.examples.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("testProperties1")
@ConfigurationProperties(prefix = "test")
public class TestProperties {
  private String origin;

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }
}
