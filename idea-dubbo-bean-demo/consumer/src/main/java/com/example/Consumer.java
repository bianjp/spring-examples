package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/*.xml"});
    context.start();
    System.out.println("================= Consumer stopped =================");
  }
}
