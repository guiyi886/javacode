package javaInternet.exp3_1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author guiyi
 * @Date 2024/5/8 下午5:27:24
 * @ClassName javaInternet.exp3_1.DomainResolver
 * @function -->
 */
public class DomainResolver {
    // 解析域名为IP地址
    public static String domainToIp(String domainName) {
        try {
            InetAddress address = InetAddress.getByName(domainName);
            return address.getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println("无法解析域名：" + domainName);
            return null;
        }
    }

    // 反向解析IP地址为主机名或域名
    public static String ipToDomain(String ipAddress) {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            return address.getHostName();
        } catch (UnknownHostException e) {
            System.out.println("无法解析IP地址：" + ipAddress);
            return null;
        }
    }
}
