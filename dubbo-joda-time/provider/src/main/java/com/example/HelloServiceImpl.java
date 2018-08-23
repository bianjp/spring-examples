package com.example;

import org.joda.time.DateTime;

public class HelloServiceImpl implements HelloService {
  @Override
  public String hello() {
    System.out.println("Called by consumer");
    return "Hello from provider";
  }

  @Override
  public DateTime testJodaTime() {
    return DateTime.now();
  }
}
