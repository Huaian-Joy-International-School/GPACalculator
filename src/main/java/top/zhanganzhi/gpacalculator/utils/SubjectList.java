package top.zhanganzhi.gpacalculator.utils;

import top.zhanganzhi.gpacalculator.module.Subject;

import java.util.ArrayList;

public record SubjectList(ArrayList<Subject> subjectArrayList) {
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
