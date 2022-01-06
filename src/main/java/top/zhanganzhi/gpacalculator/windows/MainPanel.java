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
        setPreferredSize(new Dimension(width, height));
        ((FlowLayout) getLayout()).setVgap(0);
        coursePanel = new CoursePanel(width, 350);
        buttonPanel = new ButtonPanel(width, 36);
        resultCreditLabel = new JLabel();
        resultGPALabel = new JLabel();
        resultCreditLabel.setPreferredSize(new Dimension(width / 2, 24));
        resultGPALabel.setPreferredSize(new Dimension(width / 2, 24));

        add(coursePanel);
        add(buttonPanel);
        add(resultCreditLabel);
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
