package top.zhanganzhi.gpacalculator;

import top.zhanganzhi.gpacalculator.module.Course;
import top.zhanganzhi.gpacalculator.utils.ResourcesLoader;
import top.zhanganzhi.gpacalculator.utils.Tool;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        var courseList = new ArrayList<Course>();
        var subjectTypes = ResourcesLoader.getInstance().getSubjectList().getSubjectTypesList();
        while (true) {
            System.out.println("\n========Subject Types========");
            System.out.println("0. Print Report");
            for (int i = 0; i < subjectTypes.size(); i++) {
                System.out.println((i + 1) + ". " + subjectTypes.get(i));
            }
            var typeIndex = inputInt(0, subjectTypes.size());

            if (typeIndex == 0) {
                break;
            } else {
                var type = subjectTypes.get(typeIndex - 1);
                var subjects = ResourcesLoader.getInstance().getSubjectList().getSubjectList(type);
                System.out.println("\n========Subjects========");
                for (int i = 0; i < subjects.size(); i++) {
                    System.out.println((i + 1) + ". " + subjects.get(i).getName());
                }
                var subject = subjects.get(inputInt(1, subjects.size()) - 1);

                System.out.print("Letter grade of " + subject.getName() + ": ");
                var course = new Course(subject, new Scanner(System.in).nextLine());
                courseList.add(course);
            }
        }
        System.out.println(getReportString(courseList));
    }

    public static int inputInt(int minimum, int maximum) {
        var scanner = new Scanner(System.in);
        int result;
        while (true) {
            System.out.print("Please select one: ");
            try {
                result = Integer.parseInt(scanner.nextLine());
                if (result >= minimum && result <= maximum) {
                    return result;
                }
            } catch (NumberFormatException ignored) {
            }
        }
    }

    public static String getReportString(ArrayList<Course> courseArrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%-35s", "Class"));
        stringBuilder.append(String.format("%-35s", "Grade"));
        stringBuilder.append(String.format("%-7s", "Credits"));
        stringBuilder.append("\n");
        for (var course : courseArrayList) {
            stringBuilder.append(String.format("%-35s", course.getName()));
            stringBuilder.append(String.format("%-35s", course.getLetterGrade()));
            stringBuilder.append(String.format("%-7s", course.getCredit()));
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
        stringBuilder.append("%-35s%.2f\n".formatted("Earned Credits: ", Tool.calculateCredits(courseArrayList)));
        stringBuilder.append("%-35s%.2f\n".formatted("GPA: ", Tool.calculateGPA(courseArrayList)));
        return stringBuilder.toString();
    }
}
