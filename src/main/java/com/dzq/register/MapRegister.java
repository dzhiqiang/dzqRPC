package com.dzq.register;

import com.dzq.framework.URL;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class MapRegister {

    private static Map<String, List<URL>> REGISTER = new HashMap<String, List<URL>>();

    public static void regist(String interfaceName, URL url) {
        List<URL> urls = REGISTER.get(interfaceName);
        if (urls == null) {
            urls = Arrays.asList(url);
        } else {
            urls.add(url);
        }
        REGISTER.put(interfaceName, urls);
    }

    public static URL random(String interfaceName) {

        List<URL> urls = REGISTER.get(interfaceName);

        return urls.get(new Random().nextInt(urls.size()));
    }

}
