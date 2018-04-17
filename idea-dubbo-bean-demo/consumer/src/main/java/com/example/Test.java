package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Test {
  private final HelloService helloService;

  @Autowired
  public Test(HelloService helloService) {
    this.helloService = helloService;
    System.out.println("=============== Test bean constructed ===============");
    System.out.println(helloService.hello());
  }
}
