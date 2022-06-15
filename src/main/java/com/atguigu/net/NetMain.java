package com.atguigu.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetMain {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("localHost = " + localHost);
        InetAddress name = InetAddress.getByName("www.vip.com");
        InetAddress name2 = InetAddress.getByName("www.baidu.com");
        System.out.println("name = " + name);
        System.out.println("name2 = " + name2);
        int a = 10;
    }
}
