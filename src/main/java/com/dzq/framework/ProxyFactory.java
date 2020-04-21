package com.dzq.framework;

import com.dzq.protocol.HttpProtocol;
import com.dzq.protocol.Protocol;
import com.dzq.protocol.ProtocolFactory;
import com.dzq.protocol.http.HttpClient;
import com.dzq.register.MapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static <T> T getProxy(final Class<T> interfaceClass) {

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);
                URL url = MapRegister.random(interfaceClass.getName());
                Protocol protocol = ProtocolFactory.getProtocol();
                return protocol.send(url, invocation);
            }
        });
    }

}
