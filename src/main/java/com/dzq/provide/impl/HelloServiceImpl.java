package com.dzq.provide.impl;

import com.dzq.provide.api.HelloService;

public class HelloServiceImpl implements HelloService {
    public String sayHello(String name) {
        return "hello ," + name;
    }
}
