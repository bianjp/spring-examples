package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provider {
  public static void main(String[] args) throws IOException {
    System.setProperty("java.net.preferIPv4Stack", "true");
    ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/dubbo.xml"});
    context.start();
    System.in.read();
  }
}
