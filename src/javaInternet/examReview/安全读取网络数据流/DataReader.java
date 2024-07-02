package javaInternet.examReview.安全读取网络数据流;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class DataReader {

    public static byte[] readRequestData(HttpServletRequest request) throws IOException {
        ServletInputStream inStream = request.getInputStream(); // 获取HTTP请求流
        int size = request.getContentLength(); // 获取HTTP请求流的长度
        byte[] buffer = new byte[1024]; // 缓冲区，默认为1024字节
        byte[] in_b = new byte[size]; // 用于存放结果的数组
        int count = 0; // 已读取字节数
        int rbyte = 0; // 每次实际读取的字节数

        while (count < size) { // 循环读取，直到读取完所有数据
            rbyte = inStream.read(buffer); // 读取数据到缓冲区
            if (rbyte == -1) {
                break; // 如果读取到文件末尾，跳出循环
            }
            // 将读取的数据复制到结果数组中
            System.arraycopy(buffer, 0, in_b, count, rbyte);
            count += rbyte; // 累加已读取字节数
        }

        // 返回完整的数据
        return in_b;
    }
}
