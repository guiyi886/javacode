package javaInternet.examReview.缓冲字符流;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("d:\\in.txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("d:\\out.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            while (true) {
                String s = br.readLine();
                if (s == null) break;
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            br.close();
            fw.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
