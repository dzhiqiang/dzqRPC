package com.dzq.protocol.http;

import com.dzq.framework.Invocation;
import com.dzq.provide.LocalInterfaceMap;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServerHandler {

    public void handle(HttpServletRequest req, HttpServletResponse resp) {

        try {
            InputStream is = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            Invocation invocation = (Invocation) ois.readObject();
            Class classImpl = LocalInterfaceMap.get(invocation.getInterfaceName());

            Method method = classImpl.getMethod(invocation.getMethodName(), invocation.getParamType());

            String result = (String) method.invoke(classImpl.newInstance(), invocation.getParams());

            OutputStream os = resp.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(result);
            oos.flush();
            oos.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
