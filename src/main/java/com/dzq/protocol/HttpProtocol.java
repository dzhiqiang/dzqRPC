package com.dzq.protocol;

import com.dzq.framework.Invocation;
import com.dzq.framework.URL;
import com.dzq.protocol.http.HttpClient;
import com.dzq.protocol.http.HttpServer;

public class HttpProtocol implements Protocol {
    public void start(URL url) {
        //暴露服务
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(), url.getPort());
    }

    public String send(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url.getHostname(), url.getPort(), invocation);
    }
}
