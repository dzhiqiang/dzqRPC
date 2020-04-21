package com.dzq.protocol;

import com.dzq.framework.Invocation;
import com.dzq.framework.URL;

public interface Protocol {

    void start(URL url);

    String send(URL url, Invocation invocation);

}
