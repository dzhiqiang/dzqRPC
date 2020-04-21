package com.dzq.protocol;

public class ProtocolFactory {


    public static Protocol getProtocol() {

        String protocol = System.getProperty("protocol");

        if (protocol == null || protocol.length() ==0) return new HttpProtocol();

        if (protocol.equals("http")) {
            return new HttpProtocol();
        }
        return new HttpProtocol();
    }


}
