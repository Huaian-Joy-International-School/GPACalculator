package top.zhanganzhi.gpacalculator.utils;

import com.alibaba.fastjson.JSONObject;
import top.zhanganzhi.gpacalculator.module.Subject;

import java.util.ArrayList;

public class SubjectList {
    private final ArrayList<Subject> subjectArrayList = new ArrayList<>();
    private JSONObject subjectsJSONObject;
    private String year;
    private String semester;

    public SubjectList(JSONObject subjects) {
        subjectsJSONObject = subjects;
        // 设置默认学期
        year = subjects.keySet().iterator().next();
        semester = subjects.getJSONObject(year).keySet().iterator().next();
        setSemester(year, semester);

        // 转换课程列表
        var subjectJSONArray = subjects.getJSONObject(year).getJSONArray(semester);
        for (int i = 0; i < subjectJSONArray.size(); i++) {
            var subjectTypeJSONObject = subjectJSONArray.getJSONObject(i);
            for (int j = 0; j < subjectTypeJSONObject.getJSONArray("list").size(); j++) {
                var subjectJSONObject = subjectTypeJSONObject.getJSONArray("list").getJSONObject(j);
                subjectArrayList.add(new Subject(
                        subjectTypeJSONObject.getString("type"),
                        subjectJSONObject.getString("name"),
                        subjectJSONObject.getDouble("credit")
                ));
            }
        }
    }

    public void setSemester(String year, String semester) {
        this.year = year;
        this.semester = semester;
    }

    public ArrayList<String> getYearList() {
        return new ArrayList<>(subjectsJSONObject.keySet().stream().toList());
    }

    public ArrayList<String> getSemesterList(String year) {
        return new ArrayList<>(subjectsJSONObject.getJSONObject(year).keySet().stream().toList());
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectArrayList;
    }

    public ArrayList<Subject> getSubjectList(String type) {
        return new ArrayList<>(getSubjectList().stream().filter(subject -> subject.getType().equals(type)).toList());
    }

    public ArrayList<String> getSubjectTypesList() {
        return new ArrayList<>(getSubjectList().stream().map(Subject::getType).distinct().toList());
    }

    public ArrayList<String> getSubjectNamesList() {
        return new ArrayList<>(getSubjectList().stream().map(Subject::getName).toList());
    }

    public ArrayList<String> getSubjectNamesList(String type) {
        return new ArrayList<>(getSubjectList(type).stream().map(Subject::getName).toList());
    }

    public Subject getSubject(String type, String name) {
        return getSubjectList().stream().filter(subject -> subject.getType().equals(type) && subject.getName().equals(name)).toList().get(0);
    }
}
