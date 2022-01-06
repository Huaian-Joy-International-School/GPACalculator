package top.zhanganzhi.gpacalculator.utils;

import top.zhanganzhi.gpacalculator.module.Course;

import java.io.InputStream;
import java.util.ArrayList;

public class Tool {
    public static InputStream readFileAsStream(String filePath) {
        return Tool.class.getResourceAsStream("/" + filePath);
    }

    public static byte[] readFileAsBytes(String filePath) {
        try {
            return readFileAsStream(filePath).readAllBytes();
        } catch (Exception ignored) {
        }
        return new byte[0];
    }

    public static String readFileAsString(String filePath) {
        try (var inputStream = readFileAsStream(filePath)) {
            assert inputStream != null;
            int n;
            StringBuilder stringBuilder = new StringBuilder();
            while ((n = inputStream.read()) != -1) {
                stringBuilder.append((char) n);
            }
            return stringBuilder.toString();
        } catch (Exception ignored) {
        }
        return "";
    }

    public static double calculateCredits(ArrayList<Course> courseArrayList) {
        double credits = 0.0;
        for (var course : courseArrayList) {
            credits += course.getCredit();
        }
        return credits;
    }

    public static double calculateGPA(ArrayList<Course> courseArrayList) {
        double totalGPA = 0.0;
        for (var course : courseArrayList) {
            totalGPA += course.getCredit() * course.getGPA();
        }
        return Math.round((totalGPA / calculateCredits(courseArrayList)) * 100.0) / 100.0;
    }
}
