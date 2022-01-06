package top.zhanganzhi.gpacalculator.utils;

import com.alibaba.fastjson.JSONObject;
import top.zhanganzhi.gpacalculator.module.Course;

import java.util.ArrayList;
import java.util.Comparator;

public record LetterGradeMap(JSONObject letterGradeMapJSONObject) {

    public ArrayList<String> getLetterList() {
        var result = new ArrayList<>(letterGradeMapJSONObject.keySet());
        result.sort(Comparator.naturalOrder());
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).endsWith("+") && result.get(i - 1).length() == 1) {
                var temp = result.get(i - 1);
                result.set(i - 1, result.get(i));
                result.set(i, temp);
            }
        }
        return result;
    }

    public double getGPA(Course course) {
        double GPA = letterGradeMapJSONObject.getDouble(course.getLetterGrade());
        if (course.getName().contains("AP") && !course.getLetterGrade().equals("F")) {
            GPA += 0.5;
        }
        return GPA;
    }
}
