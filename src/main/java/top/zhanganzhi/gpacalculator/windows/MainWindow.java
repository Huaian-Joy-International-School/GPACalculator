package top.zhanganzhi.gpacalculator.windows;

import top.zhanganzhi.gpacalculator.utils.ResourcesLoader;

import javax.swing.*;

public class MainWindow extends JFrame {
    private static final MainWindow instance = new MainWindow();
    private final MainPanel mainPanel;

    private MainWindow() {
        // 主界面
        mainPanel = new MainPanel(ResourcesLoader.getInstance().getApplicationProperties().getWidth(), ResourcesLoader.getInstance().getApplicationProperties().getHeight());
        add(mainPanel);

        // 窗口尺寸
        setSize(ResourcesLoader.getInstance().getApplicationProperties().getWidth(), ResourcesLoader.getInstance().getApplicationProperties().getHeight());
        setResizable(false);

        // 设置标题
        setTitle(ResourcesLoader.getInstance().getApplicationProperties().getName() + " " + ResourcesLoader.getInstance().getApplicationProperties().getVersion());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 菜单
        setJMenuBar(new MenuBar());
    }

    public static MainWindow getInstance() {
        return instance;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }
}
