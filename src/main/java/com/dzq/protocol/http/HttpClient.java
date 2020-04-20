package com.dzq.protocol.http;

import com.dzq.framework.Invocation;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClient {

    public String send(String hostname, int port, Invocation invocation) {

        try {
            URL url = new URL("http", hostname, port, "/");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream os = httpURLConnection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            InputStream is = httpURLConnection.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            String result = (String) ois.readObject();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
