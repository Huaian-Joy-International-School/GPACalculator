package top.zhanganzhi.gpacalculator;

import top.zhanganzhi.gpacalculator.windows.MainWindow;

import javax.swing.JFrame;

public class Main extends JFrame {
    public static void main(String[] args) {
        MainWindow.getInstance().setVisible(true);
        MainWindow.getInstance().getMainPanel().getCoursePanel().addCourseSelector();
    }
}
