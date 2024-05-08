package javaInternet.exp3_1;

import java.util.Scanner;

import static javaInternet.exp3_1.DomainResolver.domainToIp;
import static javaInternet.exp3_1.DomainResolver.ipToDomain;

/**
 * @author guiyi
 * @Date 2024/5/8 下午10:08:51
 * @ClassName javaInternet.exp3_1.Test
 * @function -->
 */
public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 解析域名为IP地址
        System.out.print("请输入域名：");
        String domainName = scan.next();
        String ipAddress = domainToIp(domainName);
        if (ipAddress != null) {
            System.out.println(domainName + " 的IP地址是：" + ipAddress);
        }

        // 反向解析IP地址为域名
        System.out.print("请输入IP地址：");
        String ip = scan.next();
        String hostName = ipToDomain(ip);
        if (hostName != null) {
            System.out.println(ip + " 对应的主机名是：" + hostName);
        }
    }
}
