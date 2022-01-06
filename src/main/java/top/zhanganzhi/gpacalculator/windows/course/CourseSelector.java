package top.zhanganzhi.gpacalculator.windows.course;

import top.zhanganzhi.gpacalculator.module.Course;
import top.zhanganzhi.gpacalculator.utils.LetterGradeMap;
import top.zhanganzhi.gpacalculator.utils.ResourcesLoader;
import top.zhanganzhi.gpacalculator.utils.SubjectList;
import top.zhanganzhi.gpacalculator.utils.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class CourseSelector extends JPanel {
    private final JComboBox<String> subjectTypeJComboBox;
    private final JComboBox<String> subjectNameJComboBox;
    private final JComboBox<String> letterGradeJComboBox;

    public CourseSelector(CoursePanel coursePanel) {
        subjectTypeJComboBox = new JComboBox<>(ResourcesLoader.getInstance().getSubjectList().getSubjectTypesList().toArray(String[]::new));
        subjectNameJComboBox = new JComboBox<>();
        letterGradeJComboBox = new JComboBox<>(ResourcesLoader.getInstance().getLetterGradeMap().getLetterList().toArray(String[]::new));
        JButton removeJButton = new JButton(new ImageIcon(new ImageIcon(Tool.readFileAsBytes("images/close.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

        subjectTypeJComboBox.setPreferredSize(new Dimension(109, 25));
        subjectNameJComboBox.setPreferredSize(new Dimension(226, 25));
        letterGradeJComboBox.setPreferredSize(new Dimension(43, 25));
        removeJButton.setPreferredSize(new Dimension(25, 25));

        subjectTypeJComboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                updateSubjectNameJComboBox();
            }
        });
        removeJButton.addActionListener(e -> coursePanel.removeCourseSelector(this));
        updateSubjectNameJComboBox();
        add(subjectTypeJComboBox);
        add(subjectNameJComboBox);
        add(letterGradeJComboBox);
        add(removeJButton);
    }

    private void updateSubjectNameJComboBox() {
        subjectNameJComboBox.removeAllItems();
        for (var subjectName : ResourcesLoader.getInstance().getSubjectList().getSubjectNamesList((String) subjectTypeJComboBox.getSelectedItem())) {
            subjectNameJComboBox.addItem(subjectName);
        }
    }

    public Course getCourse() {
        return new Course(
                ResourcesLoader.getInstance().getSubjectList().getSubject(
                        (String) subjectTypeJComboBox.getSelectedItem(),
                        (String) subjectNameJComboBox.getSelectedItem()
                ),
                (String) letterGradeJComboBox.getSelectedItem()
        );
    }
}
