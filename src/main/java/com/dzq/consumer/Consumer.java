package com.dzq.consumer;

import com.dzq.framework.Invocation;
import com.dzq.framework.ProxyFactory;
import com.dzq.protocol.http.HttpClient;
import com.dzq.provide.api.HelloService;

public class Consumer {

    public static void main(String[] args) {

        HelloService helloService = ProxyFactory.getProxy(HelloService.class);

        String result = helloService.sayHello("132");

        System.out.println(result);

    }

}
