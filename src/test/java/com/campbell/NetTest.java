package com.campbell;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;

/**
 * @author Campbell
 * @date 2021/6/11
 */
public class NetTest {

    @Test
    public void test() throws Exception{
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println("ip1: "+ip1);

        // 获取百度ip地址对象
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println("ip2:"+ip2);

        // 获得本地的主机名
        String hostName = ip1.getHostName();
        System.out.println("hostName:"+hostName);

        // 获得本地的ip地址
        String hostAddress = ip1.getHostAddress();
        System.out.println("hostAddress:"+hostAddress);
    }
}
