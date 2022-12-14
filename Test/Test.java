import java.awt.Container;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Test {
    public static void main(String[] args) {
        new MyFrame();
    }
}

// class MyFrame extends JFrame implements ActionListener {
class MyFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    MenuBar menuBar; // 菜单栏
    Menu student; // 菜单
    MenuItem add, show; // 菜单项
    Panel contentPanel; // 内容面板，其上用于添加其他待切换的面板

    public MyFrame() {
        // 初始化组件
        menuBar = new MenuBar();
        student = new Menu("学生");
        add = new MenuItem("添加");
        show = new MenuItem("查看");
        contentPanel = new Panel();

        // 菜单项添加事件监听器
        // add.addActionListener(this);
        // show.addActionListener(this);

        // 设置窗口的菜单栏，菜单和各个菜单项。
        student.add(add);
        student.add(show);
        menuBar.add(student);
        setMenuBar(menuBar);

        // 设置布局为边界布局管理器。将contentPanel添加到窗口中心位置。
        this.setContentPane(new MyPanel("这是欢迎页 - setContentPane()"));

        // 窗口的其他参数
        setTitle("测试");
        setBounds(300, 50, 400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    // Object source = e.getSource();
    // if (source == add) {
    // changeContentPane(new MyPanel("添加学生信息 - setContentPane()"));
    // } else if (source == show) {
    // changeContentPane(new MyPanel("查看学生信息 - setContentPane()"));
    // }
    // }

    // 切换内容面板
    public void changeContentPane(Container contentPane) {
        this.setContentPane(contentPane);
        this.revalidate();
    }

}

// 简易地获取所需的面板(使用时需自定义)
class MyPanel extends Panel {
    public MyPanel(String msg) {
        this.add(new Label(msg));
    }
}
