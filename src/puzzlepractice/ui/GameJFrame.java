package puzzlepractice.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;



public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //规定是游戏的主界面

    //创建一个二维数组
    int[][] ArrTest2 = new int[4][4];
    //记录空白方块在二维数组中的位置
    int x = 0;
    int y = 0;

    //记录一张照片
    String picture = "D:\\puzzlegame\\puzzlegame\\image\\animal\\";

    //定义变量，统计步数
    int stepcount=0;

    //定义一个二维数组
    int win[][] = {
            {0, 1, 2, 3},
            {4, 5, 6, 7},
            {8, 9, 10, 11},
            {12, 13, 14, 15}
    };

    //创建条目
    JMenuItem ReplayItem = new JMenuItem("重新开始");
    JMenuItem ReLoginItem = new JMenuItem("重新登录");
    JMenuItem BackItem = new JMenuItem("退出游戏");
    JMenu restartItem = new JMenu("换一张图片");

    JMenuItem PlayItem = new JMenuItem("请点击");

    JMenuItem twojmenu1=new JMenuItem("美女");
    JMenuItem twojmenu2=new JMenuItem("动物");
    JMenuItem twojmenu3=new JMenuItem("运动");

    String thing="animal";

    public GameJFrame() {

        //初始化界面
        initJFrame();

        //初始化菜单
        InitJMenuBar();

        //初始化数据（打乱）
        InitData();

        //初始化照片（根据打乱后的的数据进行照片的放置）
        InitJImage();

        //让显示显示出来，写在最后
        this.setVisible(true);
    }

    private void InitData() {
        //新建一个一维数组
        int[] ArrTest = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,};

        //遍历数组，得到每一个元素，拿这个元素和随机指引上的元素进行交换
        Random rand = new Random();
        for (int i = 0; i < ArrTest.length; i++) {
            int t = rand.nextInt(ArrTest.length);//注意这里的表示方法
            int temp = ArrTest[i];
            ArrTest[i] = ArrTest[t];
            ArrTest[t] = temp;
        }

        int num = 0;
        for (int i = 0; i < ArrTest2.length; i++) {
            for (int j = 0; j < ArrTest2[i].length; j++) {

                ArrTest2[i][j] = ArrTest[num];
                if (ArrTest2[i][j] == 15) {
                    x = i;
                    y = j;
                }
                num++;
            }
        }
        for (int i = 0; i < ArrTest2.length; i++) {
            for (int j = 0; j < ArrTest2[i].length; j++) {
                System.out.print(ArrTest2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(x + " " + y);

    }

    private void InitJImage() {
/*        //创建一个ImageIcon的对象
        ImageIcon icon = new ImageIcon("D:\\puzzlegame\\puzzlegame\\image\\animal\\animal1\\1.jpg");
        //创建一个JLabel的对象（管理容器）
        JLabel label1 = new JLabel(icon);
        //指定图片的位置
        label1.setBounds(0,0,105,105);
        //把管理容器加入到界面中
        //this.add(label);
        this.getContentPane().add(label1);//注意这里的写法

 */
        //清空原本已经出现的拼图图案
        this.getContentPane().removeAll();

        JLabel count = new JLabel("步数："+stepcount);
        count.setBounds(50,30,100,20);
        this.getContentPane().add(count);

        if(victory()){
            JLabel winlabel = new JLabel(new ImageIcon("D:\\puzzlegame\\puzzlegame\\image\\win.png"));

            winlabel.setBounds(203,283,197,73);
            this.getContentPane().add(winlabel);

        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = ArrTest2[i][j] + 1;
                //注意后面路径的写法
                JLabel label = new JLabel(new ImageIcon(picture + thing + "3\\" + num + ".jpg"));
                label.setBounds(105 * j + 83, 105 * i + 134, 105, 105);

                //给图片设计边框
                label.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(label);

            }
        }



        //添加背景图片，先加载的图片在上面
        JLabel back = new JLabel(new ImageIcon("D:\\puzzlegame\\puzzlegame\\image\\background.png"));
        back.setBounds(40, 40, 508, 560);
        //把背景图片添加到界面中
        this.getContentPane().add(back);

        //刷新一下界面
        this.getContentPane().repaint();

    }

    private void InitJMenuBar() {
        //创建菜单
        JMenuBar menuBar = new JMenuBar();
        //创建选项
        JMenu FunctionJMenu = new JMenu("功能");
        JMenu AboutusJMenu = new JMenu("关于游戏");


        //给条目绑定事件
        ReplayItem.addActionListener(this);
        ReLoginItem.addActionListener(this);
        BackItem.addActionListener(this);
        PlayItem.addActionListener(this);

        //加入 结合
        FunctionJMenu.add(ReplayItem);
        FunctionJMenu.add(ReLoginItem);
        FunctionJMenu.add(BackItem);
        FunctionJMenu.add(restartItem);

        AboutusJMenu.add(PlayItem);

        menuBar.add(FunctionJMenu);
        menuBar.add(AboutusJMenu);



        restartItem.add(twojmenu1);
        restartItem.add(twojmenu2);
        restartItem.add(twojmenu3);

        twojmenu1.addActionListener(this);
        twojmenu2.addActionListener(this);
        twojmenu3.addActionListener(this);

        //给整个页面设置菜单
        this.setJMenuBar(menuBar);
    }

    private void initJFrame() {
        //设置界面的宽高
        this.setSize(603, 680);
        //设置界面的可视化
        this.setVisible(true);
        //设置界面的标题
        this.setTitle("拼图单机版");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面的关闭模式
        this.setDefaultCloseOperation(3);
        //取消隐式的居中放置，只有取消了才能用XY的方法放置
        // 禁用布局管理器
        this.setLayout(null);
        //设计键盘监听的设置
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //按下不松
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel newjlabel = new JLabel(new ImageIcon(picture+thing+ "3\\"+"all.jpg"));
            newjlabel.setBounds(83, 134, 420, 420);
            this.getContentPane().add(newjlabel);
            //添加背景图片，先加载的图片在上面
            JLabel back = new JLabel(new ImageIcon("D:\\puzzlegame\\puzzlegame\\image\\background.png"));
            back.setBounds(40, 40, 508, 560);
            //把背景图片添加到界面中
            this.getContentPane().add(back);
            //刷新界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否胜利，胜利的话直接结束游戏
        if(victory()){
            return;
        }
        //左：37 上：38 右：39 下：40
        int code = e.getKeyCode();
        if (code == 37) {
            if (y == 3) return;
            //把空白方块下面的数字赋值给空白方块
            ArrTest2[x][y] = ArrTest2[x][y + 1];
            ArrTest2[x][y + 1] = 15;
            y++;
            stepcount++;
            //调用方法按照最新的数字加载图片,这里是方块移动的关键！！！
            InitJImage();

        } else if (code == 38) {
            if (x == 3) return;
            //把空白方块下面的数字赋值给空白方块
            ArrTest2[x][y] = ArrTest2[x + 1][y];
            ArrTest2[x + 1][y] = 15;
            x++;
            stepcount++;
            //调用方法按照最新的数字加载图片,这里是方块移动的关键！！！
            InitJImage();

        } else if (code == 39) {
            if (y == 0) return;
            //把空白方块下面的数字赋值给空白方块
            ArrTest2[x][y] = ArrTest2[x][y - 1];
            ArrTest2[x][y - 1] = 15;
            y--;
            stepcount++;
            //调用方法按照最新的数字加载图片,这里是方块移动的关键！！！
            InitJImage();
        } else if (code == 40) {
            if (x == 0) return;
            //把空白方块下面的数字赋值给空白方块
            ArrTest2[x][y] = ArrTest2[x - 1][y];
            ArrTest2[x - 1][y] = 15;
            x--;
            stepcount++;
            //调用方法按照最新的数字加载图片,这里是方块移动的关键！！！
            InitJImage();
        } else if (code == 65) {
            InitJImage();
        } else if (code == 87) {
            ArrTest2 = new int[][]{
                    {0, 1, 2, 3},
                    {4, 5, 6, 7},
                    {8, 9, 10, 11},
                    {12, 13, 14, 15}
            };
            InitJImage();
        }
    }

    //判断现数组中是否和win数组中的相同
    public boolean victory() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (win[i][j] != ArrTest2[i][j]) {
                    return false;
                }

            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();
        if (obj == ReplayItem) {
            stepcount=0;
            InitData() ;
            InitJImage();
        }else if (obj == ReLoginItem) {
            //关闭当前界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();

        }else if (obj == BackItem) {
            //关闭虚拟机
            System.exit(0);
        }else if(obj == PlayItem) {
            //创建一个弹框对象
            JDialog  dialog = new JDialog();
            JLabel ilabel=new JLabel(new ImageIcon("D:\\puzzlegame\\puzzlegame\\image\\about.png"));

            ilabel.setBounds(0,0,258,258);

            dialog.getContentPane().add(ilabel);
            //给弹框设置大小
            dialog.setSize(344,344);
            dialog.setAlwaysOnTop(true);
            dialog.setLocationRelativeTo(null) ;

            //弹框不关闭则无法进行下面的步骤
            dialog.setModal(true);

            dialog.setVisible(true);

        }else if(obj==twojmenu1){
            System.out.println("换成美女");
            thing="girl";
            picture="D:\\puzzlegame\\puzzlegame\\image\\girl\\";
            stepcount=0;
            InitData();
            InitJImage();
        }else if(obj==twojmenu3){
            System.out.println("换成运动");
            thing="sport";
            picture="D:\\puzzlegame\\puzzlegame\\image\\sport\\";
            stepcount=0;
            InitData();
            InitJImage();
        }else if(obj==twojmenu2){
            System.out.println("换成动物");
            thing="sport";
            picture="D:\\puzzlegame\\puzzlegame\\image\\animal\\";
            stepcount=0;
            InitData();
            InitJImage();
        }
    }
}

