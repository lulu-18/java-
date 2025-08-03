package test.practice;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {
    public MyJFrame2() {
        //设置界面的宽高
        this.setSize(500, 500);
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

        JButton button1=new JButton("点我");
        JButton button2=new JButton("点我");
        button1.setBounds(0,0,50,50);
        button2.setBounds(100,0,100,50);
        button1.addMouseListener(this);
        button2.addMouseListener(this);
        this.add(button1);
        this.add(button2);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
