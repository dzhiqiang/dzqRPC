package com.dzq.framework;

import org.omg.CORBA.PRIVATE_MEMBER;

public class URL {

    private String hostname;
    private int prot;

    public URL(String hostname, int prot) {
        this.hostname = hostname;
        this.prot = prot;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getProt() {
        return prot;
    }

    public void setProt(int prot) {
        this.prot = prot;
    }
}
