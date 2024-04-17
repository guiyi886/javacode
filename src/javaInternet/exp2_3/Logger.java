package javaInternet.exp2_3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static final String LOG_FILE_PATH = "D:\\log.txt";

    // 记录连接日志
    public static void logConnection(Socket clientSocket) {
        String clientIP = clientSocket.getInetAddress().getHostAddress();
        int clientPort = clientSocket.getPort();
        String timestamp = getCurrentTimestamp();

        String logMessage = String.format("[%s] Client connected: %s:%d", timestamp, clientIP, clientPort);

        writeLog(logMessage);
    }

    // 获取当前时间戳
    private static String getCurrentTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        return dateFormat.format(now);
    }

    // 写入日志
    private static void writeLog(String logMessage) {
        try {
            synchronized (Logger.class) {
                PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_PATH, true));
                writer.println(logMessage);
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
