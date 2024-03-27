package javaLow.storage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GetURL {
    public static void main(String args[]) {
        new WinOne();
    }
}

class WinOne extends JFrame implements ActionListener, Runnable {
    JButton button;
    URL url;
    JTextField text;
    JEditorPane editPane;
    Thread thread;

    public WinOne() {
        text = new JTextField(20);
        editPane = new JEditorPane();
        editPane.setEditable(false);
        button = new JButton("确定");
        button.addActionListener(this);

        JPanel p = new JPanel();
        p.add(new JLabel("输入网址:"));
        p.add(text);
        p.add(button);

        Container con = getContentPane();
        con.add(new JScrollPane(editPane), BorderLayout.CENTER);
        con.add(p, BorderLayout.NORTH);

        setBounds(300, 100, 1080, 900);
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        thread = new Thread(this); // 创建线程但没有启动
    }


    public void actionPerformed(ActionEvent e) {
        if (!(thread.isAlive())) {
            thread = new Thread(this);
        }
        try {
            thread.start();
        } catch (Exception ee) {
            text.setText("我正在读取" + url);
        }
    }

    public void run() {
        try {
            url = new URL(text.getText().trim());   // https://baidu.com

            int n = -1;

            editPane.setText(null);

            editPane.setPage(url); // !
        } catch (MalformedURLException e1) {
            text.setText("" + e1);
            return;
        } catch (IOException e1) {
            text.setText("" + e1);
            return;
        }
    }

}





