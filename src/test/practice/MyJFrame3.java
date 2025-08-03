package test.practice;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyJFrame3 extends JFrame implements KeyListener {
    public MyJFrame3() {
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

        //给整个窗体添加键盘监听
        this.addKeyListener(this);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开");
    }
}
