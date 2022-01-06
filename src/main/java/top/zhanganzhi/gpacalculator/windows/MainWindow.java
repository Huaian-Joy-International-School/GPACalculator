package top.zhanganzhi.gpacalculator.windows;

import top.zhanganzhi.gpacalculator.utils.ApplicationProperties;
import top.zhanganzhi.gpacalculator.utils.ResourcesLoader;

import javax.swing.*;

public class MainWindow extends JFrame {
    private static final MainWindow instance = new MainWindow();
    private final MainPanel mainPanel;

    private MainWindow() {
        mainPanel = new MainPanel(ResourcesLoader.getInstance().getApplicationProperties().getWidth(), ResourcesLoader.getInstance().getApplicationProperties().getHeight());
        add(mainPanel);

        setSize(ResourcesLoader.getInstance().getApplicationProperties().getWidth(), ResourcesLoader.getInstance().getApplicationProperties().getHeight());
        setResizable(false);
        setTitle(ResourcesLoader.getInstance().getApplicationProperties().getName() + " " + ResourcesLoader.getInstance().getApplicationProperties().getVersion());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static MainWindow getInstance() {
        return instance;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }
}
