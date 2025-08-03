package test.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyJFrame extends JFrame implements ActionListener {//接口的实现,实现了内部类
    //设置两个按钮
    JButton button1=new JButton();
    JButton button2=new JButton();
    public MyJFrame() {
        //设置界面的宽高
        this.setSize(603, 680);
        //设置界面的可视化
        this.setVisible(true);
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面的关闭模式
        this.setDefaultCloseOperation(3);
        //取消隐式的居中放置，只有取消了才能用XY的方法放置
        // 禁用布局管理器
        this.setLayout(null);

        //给这个按钮设置位置和宽高
        button1.setBounds(0,0,50,50);
        //给按钮设置动作监听
        button1.addActionListener(this);//执行本类中对应的代码

        //给这个按钮设置位置和宽高
        button2.setBounds(100,0,50,50);
        //给按钮设置动作监听
        button2.addActionListener(this);//执行本类中对应的代码

        //把按钮添加到整个界面当中
        this.getContentPane().add(button1);
        this.getContentPane().add(button2);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //对当前的按钮进行判断
        Object obj=e.getSource();//获取当前操作的按钮
        if(obj==button1){
            button1.setSize(100,100);
        }else if(obj==button2){
            button2.setSize(100,100);
        }
    }
}
