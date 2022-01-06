package top.zhanganzhi.gpacalculator.test;

import java.util.HashMap;
import java.util.Scanner;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class Test {
    public static void main(String[] args) {
    }

    public static void version1() {
        double mathGPA = 4.0;
        double mathCredit = 0.5;
        double englishGPA = 3.7;
        double englishCredit = 0.5;
        double historyGPA = 3.3;
        double historyCredit = 0.25;

        double totalGPA = mathGPA * mathCredit + englishGPA * englishCredit + historyGPA * historyCredit;
        double totalCredit = mathCredit + englishCredit + historyCredit;
        System.out.printf("总GPA为: %.2f", totalGPA / totalCredit);
    }

    public static void version2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数学成绩：");
        double mathGPA = scanner.nextDouble();
        System.out.print("请输入数学学分：");
        double mathCredit = scanner.nextDouble();
        System.out.print("请输入英语成绩：");
        double englishGPA = scanner.nextDouble();
        System.out.print("请输入英语学分：");
        double englishCredit = scanner.nextDouble();
        System.out.print("请输入历史成绩：");
        double historyGPA = scanner.nextDouble();
        System.out.print("请输入历史学分：");
        double historyCredit = scanner.nextDouble();

        double totalGPA = mathGPA * mathCredit + englishGPA * englishCredit + historyGPA * historyCredit;
        double totalCredit = mathCredit + englishCredit + historyCredit;
        System.out.printf("总GPA为: %.2f", totalGPA / totalCredit);
    }

    public static void version3() {
        var scanner = new Scanner(System.in);
        double totalCredit = 0.0;
        double totalGPA = 0.0;
        while (true) {
            System.out.print("The class credit(input 0 to stop): ");
            double credit = scanner.nextDouble();
            if (credit == 0) {
                break;
            }
            totalCredit += credit;
            System.out.print("The class GPA: ");
            totalGPA += credit * scanner.nextDouble();
        }
        System.out.printf("Your GPA is %.2f\n", totalGPA / totalCredit);
    }

    public static void version4() {
        var letterGradeMap = new HashMap<String, Double>();
        letterGradeMap.put("A", 4.0);
        letterGradeMap.put("A-", 3.7);
        letterGradeMap.put("B+", 3.3);
        letterGradeMap.put("B", 3.0);
        letterGradeMap.put("B-", 2.7);
        letterGradeMap.put("C+", 2.3);
        letterGradeMap.put("C", 2.0);
        letterGradeMap.put("C-", 1.7);
        letterGradeMap.put("D+", 1.3);
        letterGradeMap.put("D", 1.0);
        letterGradeMap.put("D-", 0.7);
        letterGradeMap.put("F", 0.0);
        var scanner = new Scanner(System.in);
        double totalCredit = 0.0;
        double totalGPA = 0.0;
        while (true) {
            System.out.print("The class credit(input 0 to stop): ");
            double credit = Double.parseDouble(scanner.nextLine());
            if (credit == 0) {
                break;
            } else {
                totalCredit += credit;
            }
            System.out.print("The class letter grade(Add '+' before if honor): ");
            String letterGrade = scanner.nextLine();
            double gpa;
            if (letterGrade.startsWith("+") && !letterGrade.equals("F")) {
                gpa = letterGradeMap.get(letterGrade.replaceAll("^\\+", "")) + 0.5;
            } else {
                gpa = letterGradeMap.get(letterGrade);
            }
            totalGPA += credit * gpa;
        }
        System.out.printf("Your GPA is %.2f\n", totalGPA / totalCredit);
    }
}
