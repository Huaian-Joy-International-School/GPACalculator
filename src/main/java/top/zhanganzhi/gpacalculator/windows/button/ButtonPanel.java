package top.zhanganzhi.gpacalculator.windows.button;

import top.zhanganzhi.gpacalculator.utils.Tool;
import top.zhanganzhi.gpacalculator.windows.MainWindow;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private final JButton addJButton;

    public ButtonPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        addJButton = new JButton("添加");
        JButton calculateJButton = new JButton("计算");

        addJButton.addActionListener(e -> MainWindow.getInstance().getMainPanel().getCoursePanel().addCourseSelector());
        calculateJButton.addActionListener(e -> {
            var courseArrayList = MainWindow.getInstance().getMainPanel().getCoursePanel().getCourseList();
            MainWindow.getInstance().getMainPanel().setResult(Tool.calculateCredits(courseArrayList), Tool.calculateGPA(courseArrayList));
        });
        add(addJButton);
        add(calculateJButton);
    }

    public void setAddJButtonEnable(boolean b) {
        addJButton.setEnabled(b);
    }
}
