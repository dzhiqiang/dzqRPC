package com.dzq.provide;

import com.dzq.framework.URL;
import com.dzq.protocol.http.HttpServer;
import com.dzq.provide.api.HelloService;
import com.dzq.provide.impl.HelloServiceImpl;
import com.dzq.register.MapRegister;

public class Provide {

    public static void main(String[] args) {

        //注册服务
        URL url = new URL("localhost", 8080);
        MapRegister.regist(HelloService.class.getName(), url);
        LocalInterfaceMap.put(HelloService.class.getName(), HelloServiceImpl.class);
        //暴露服务
        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8080);
    }

}
