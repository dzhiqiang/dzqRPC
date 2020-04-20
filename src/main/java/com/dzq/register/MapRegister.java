package com.dzq.register;

import com.dzq.framework.URL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}
