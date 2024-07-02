package javaInternet.examReview.安全算法摘要;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestThread extends Thread {

    private String filename;

    public DigestThread(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in, sha);

            // 读取文件内容，更新摘要信息
            while (din.read() != -1) ;
            din.close();

            // 计算最终的摘要值
            byte[] digest = sha.digest();

            // 将摘要转换为十六进制字符串
            String hexDigest = bytesToHex(digest);

            // 构建输出结果
            StringBuilder result = new StringBuilder(filename);
            result.append(": ");
            result.append(hexDigest);
            System.out.println(result);
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex);
        }
    }

    // 将字节数组转换为十六进制字符串的方法
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b)); // 使用两位十六进制表示一个字节
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Thread t = new DigestThread("d:\\in.txt");
        t.start();
    }
}
