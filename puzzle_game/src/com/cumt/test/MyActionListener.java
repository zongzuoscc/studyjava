package com.cumt.test;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MyActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("按钮被点击了");
    }
}
