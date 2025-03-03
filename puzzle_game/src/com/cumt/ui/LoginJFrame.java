package com.cumt.ui;
import javax.swing.*;
public class LoginJFrame extends JFrame{
    public LoginJFrame(){
        //设置界面的宽高
        this.setSize(488,430);
        this.setTitle("拼图登录");//设置标题
        this.setAlwaysOnTop(true);//设置界面置顶
        this.setLocationRelativeTo(null);//设置界面居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭模式
        this.setVisible(true);
    }
}
