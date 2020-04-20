package com.dzq.provide;

import java.util.HashMap;
import java.util.Map;

public class LocalInterfaceMap {

    public static Map<String, Class> MAP = new HashMap<String, Class>();

    public static void put(String interfaceName, Class implClass) {
        MAP.put(interfaceName, implClass);
    }

    public static Class get(String interfaceName) {
        return MAP.get(interfaceName);
    }


}
