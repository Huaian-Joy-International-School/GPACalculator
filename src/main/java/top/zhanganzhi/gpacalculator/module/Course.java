package top.zhanganzhi.gpacalculator.module;

import top.zhanganzhi.gpacalculator.utils.LetterGradeMap;
import top.zhanganzhi.gpacalculator.utils.ResourcesLoader;

public class Course extends Subject {
    private final Subject subject;
    private final String letterGrade;

    public Course(Subject subject, String letterGrade) {
        super(subject.getType(), subject.getName(), subject.getCredit());
        this.subject = subject;
        this.letterGrade = letterGrade;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public double getGPA() {
        return ResourcesLoader.getInstance().getLetterGradeMap().getGPA(this);
    }

    @Override
    public String toString() {
        return "Course{" +
                "type='" + subject.getType() + '\'' +
                ", name='" + subject.getName() + '\'' +
                ", credit=" + subject.getCredit() +
                ", letterGrade='" + letterGrade + '\'' +
                '}';
    }
}
