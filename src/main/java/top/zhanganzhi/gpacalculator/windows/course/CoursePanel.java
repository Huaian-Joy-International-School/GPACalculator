package top.zhanganzhi.gpacalculator.windows.course;

import top.zhanganzhi.gpacalculator.module.Course;
import top.zhanganzhi.gpacalculator.windows.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CoursePanel extends JPanel {
    private final ArrayList<CourseSelector> courseSelectors = new ArrayList<>();

    public CoursePanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        ((FlowLayout) getLayout()).setVgap(0);
    }

    public void addCourseSelector() {
        courseSelectors.add(new CourseSelector(this));
        update();
    }

    public void removeCourseSelector(CourseSelector courseSelector) {
        courseSelectors.remove(courseSelector);
        update();
    }

    private void update() {
        MainWindow.getInstance().getMainPanel().getButtonPanel().setAddJButtonEnable(MainWindow.getInstance().getMainPanel().getCoursePanel().getCourseList().size() < 9);
        removeAll();
        for (var courseSelector : courseSelectors) {
            add(courseSelector);
        }
        updateUI();
    }

    public ArrayList<Course> getCourseList() {
        return new ArrayList<>(courseSelectors.stream().map(CourseSelector::getCourse).toList());
    }
}
