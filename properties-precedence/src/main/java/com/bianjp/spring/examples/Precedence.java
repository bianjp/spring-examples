package com.bianjp.spring.examples;

import com.bianjp.spring.examples.config.Test2Properties;
import com.bianjp.spring.examples.config.TestProperties;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Precedence {
  private final TestProperties test1;
  private final TestProperties test2;
  private final Test2Properties test2Properties;

  @Value("${test.origin}")
  private String origin;

  public Precedence(
      @Qualifier("testProperties1") TestProperties testProperties1,
      @Qualifier("testProperties2") TestProperties testProperties2,
      Test2Properties test2Properties) {
    this.test1 = testProperties1;
    this.test2 = testProperties2;
    this.test2Properties = test2Properties;
  }

  @PostConstruct
  public void test() {
    System.out.println("----------------------------------------------------------------------");
    print("@ConfigurationProperties", test1.getOrigin());
    print("XML placeholder TestProperties", test2.getOrigin());
    print("XML placeholder Test2Properties", test2Properties.getOrigin());
    print("@Value", origin);
    System.out.println("----------------------------------------------------------------------");
    System.exit(0);
  }

  private void print(String method, String value) {
    System.out.println(String.format("%35s: %s", method, value));
  }
}
