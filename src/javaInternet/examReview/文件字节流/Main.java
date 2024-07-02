package javaInternet.examReview.文件字节流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            File file = new File("d:\\hello.txt");
            byte[] b = "深圳大学".getBytes("gbk");
            FileOutputStream output = new FileOutputStream(file);
            output.write(b); // 字节数组
            output.close();
            FileInputStream input = new FileInputStream(file);
            int n = 0;
            while ((n = input.read(b, 0, 2)) != -1) // 最多读2个字节
            {
                String str = new String(b, 0, 2, "gbk"); // 转换为字符串
                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
