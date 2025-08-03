import puzzlepractice.ui.GameJFrame;
import puzzlepractice.ui.LoginJFrame;
import puzzlepractice.ui.RegisterJFrame;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class App {
    public static void main(String[] args) {
        //表示程序的启动入口
        //想开启谁的界面，就创建谁的对象
        //new GameJFrame();
        //new RegisterJFrame();
        new LoginJFrame();
    }
}