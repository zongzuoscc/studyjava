package com.cumt.test;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test2 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(603, 680);
        jFrame.setTitle("事件演示");
        jFrame.setAlwaysOnTop(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        JButton jtb = new JButton("按钮");
        jtb.setBounds(0, 0, 100, 50);
        jFrame.add(jtb);
        //参数表示事件被触发之后要执行的代码
        //匿名内部类
        jtb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击了");
            }
        });
        jFrame.getContentPane().add(jtb);
        jFrame.setVisible(true);
    }
}
