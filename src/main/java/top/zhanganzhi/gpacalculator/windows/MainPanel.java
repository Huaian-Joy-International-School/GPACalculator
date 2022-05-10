package top.zhanganzhi.gpacalculator.windows;

import top.zhanganzhi.gpacalculator.windows.button.ButtonPanel;
import top.zhanganzhi.gpacalculator.windows.course.CoursePanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private final CoursePanel coursePanel;
    private final ButtonPanel buttonPanel;
    private final JLabel resultCreditLabel;
    private final JLabel resultGPALabel;

    public MainPanel(int width, int height) {
        // 尺寸和布局
        setPreferredSize(new Dimension(width, height));
        ((FlowLayout) getLayout()).setVgap(0);

        // 课程面板
        coursePanel = new CoursePanel(width, 350);
        add(coursePanel);

        // 按钮面板
        buttonPanel = new ButtonPanel(width, 36);
        add(buttonPanel);

        // 结果
        resultCreditLabel = new JLabel();
        resultCreditLabel.setPreferredSize(new Dimension(width / 2, 24));
        add(resultCreditLabel);
        resultGPALabel = new JLabel();
        resultGPALabel.setPreferredSize(new Dimension(width / 2, 24));
        add(resultGPALabel);
    }

    public CoursePanel getCoursePanel() {
        return coursePanel;
    }

    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setResult(double credit, double gpa) {
        resultCreditLabel.setText("Earned Credits: " + credit);
        resultGPALabel.setText("GPA: " + gpa);
    }
}
