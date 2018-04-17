package com.example;

public class HelloServiceImpl implements HelloService {
  @Override
  public String hello() {
    System.out.println("Called by consumer");
    return "Hello, Dubbo";
  }
}
