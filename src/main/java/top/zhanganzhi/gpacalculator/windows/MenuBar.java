package top.zhanganzhi.gpacalculator.windows;

import top.zhanganzhi.gpacalculator.utils.ResourcesLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class MenuBar extends JMenuBar {
    private final JMenu menuSetting;

    public MenuBar() {
        menuSetting = new JMenu("设置");
        add(menuSetting);
        setSemester();
    }

    public void setSemester() {
        var setSemesterMenuItem = new JMenuItem("学期选择");
        setSemesterMenuItem.addActionListener(new ActionListener() {
            private JFrame setSemesterFrame;
            private JComboBox<String> selectYear;
            private JComboBox<String> selectSemester;

            private void updateSelectSemester() {
                selectSemester.removeAllItems();
                for (var subjectName : ResourcesLoader.getInstance().getSubjectList().getSemesterList((String) selectYear.getSelectedItem()).toArray(String[]::new)) {
                    selectSemester.addItem(subjectName);
                }
            }

            @Override
            public void actionPerformed(ActionEvent ignore) {
                // 设置窗口
                setSemesterFrame = new JFrame("学期选择");
                setSemesterFrame.setSize(new Dimension(300, 100));
                setSemesterFrame.setVisible(true);

                // Panel
                var setSemesterPanel = new JPanel();
                setSemesterPanel.setSize(new Dimension(300, 100));
                setSemesterFrame.add(setSemesterPanel);

                // 年份选择
                selectYear = new JComboBox<>(ResourcesLoader.getInstance().getSubjectList().getYearList().toArray(String[]::new));
                selectYear.setSize(new Dimension(100, 50));
                selectYear.addItemListener(e -> {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        updateSelectSemester();
                    }
                });
                setSemesterPanel.add(selectYear);

                // 学期选择
                selectSemester = new JComboBox<>();
                updateSelectSemester();
                selectSemester.setSize(new Dimension(200, 50));
                selectSemester.addItemListener(e -> {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        System.out.println(selectYear.getSelectedItem() + " " + selectSemester.getSelectedItem());
                    }
                });
                setSemesterPanel.add(selectSemester);

                // 确定

            }
        });
        menuSetting.add(setSemesterMenuItem);
    }
}
