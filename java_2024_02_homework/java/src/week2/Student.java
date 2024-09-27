package week2;

import java.util.Scanner;

public class Student {
    IntArray intArray;
    int point;
    int id;
    String name;
    int year;
    int[] score = new int[3];
    char[] grade = new char[3];
    String answer = "y";
    Scanner scan = new Scanner(System.in);

    void read(Scanner scan) {
        id = scan.nextInt();
        name = scan.next();
        year = scan.nextInt();
        for (int i = 0; i < 3; i++) {
            score[i] = scan.nextInt();
            grade[i] = calculateGrade(score[i]);
        }
    }


    char calculateGrade(int score) {
        switch (score / 10) {
            case 10:
            case 9:
                return 'A';
            case 8:
                return 'B';
            case 7:
                return 'C';
            case 6:
                return 'D';
            default:
                return 'F';
        }
    }

    void print() {
        System.out.printf("%d %s (%d학년)\t%d (%c)\t%d (%c)\t%d (%c)\n",
                id, name, year, score[0], grade[0], score[1], grade[1], score[2], grade[2]);
    }



    void menu(int n, Student[] stList) {
        intArray = new IntArray(n);
        System.out.print("점수를 수정할 과목 번호 (1) 국어 (2) 영어 (3) 수학... ");
        int subject = scan.nextInt();
        System.out.printf("%d명 점수 입력...\n", n);
        intArray.generate(0, 101);
        intArray.print();
        pointMenu(n, subject, stList);
    }

    void pointMenu(int n, int subject, Student[] stList) {
        System.out.print("\n점수 반영하시겠습니까? (y/n): ");
        switch (scan.next()) {
            case "y":
                System.out.print("(1) 점수 그대로 반영 (2) 높은 점수 반영: ");
                reflectMenu(scan.nextInt(), n, subject, stList);
                break;
            case "n":
                System.out.println("메뉴 선택 (1) 점수 조정 (2) 다시 생성 (3) 취소/종료... ");
                adjustMenu(scan, subject, stList);
                break;
        }
    }

    // 반영 방법 선택
    void reflectMenu(int choice, int n, int subject, Student[] stList) {
        // 점수 반영 루프
        for (int i = 0; i < n; i++) {  // 모든 학생에 대해 점수 반영
            if (choice == 1) {
                // 점수 그대로 반영
                stList[i].score[subject - 1] = intArray.get(i);
            } else if (choice == 2) {
                // 기존 점수와 새로운 점수 중 높은 점수 반영
                if (intArray.get(i) > stList[i].score[subject - 1]) {
                    stList[i].score[subject - 1] = intArray.get(i);
                }
            }
            // 반영된 학점 계산
            stList[i].grade[subject - 1] = stList[i].calculateGrade(stList[i].score[subject - 1]);
        }

        // 변경된 모든 학생 정보 출력
        System.out.println("점수 반영 후 모든 학생 정보:");
        for (int i = 0; i < n; i++) {
            stList[i].print();  // 모든 학생의 정보를 출력
        }
    }


    // 점수 조정 또는 다시 생성
    void adjustMenu(Scanner scan, int subject, Student[] stList) {
        switch (scan.nextInt()) {
            case 1:
                System.out.print("조정할 점수 구간 최저 최고: ");
                int lower = scan.nextInt();
                int upper = scan.nextInt();
                intArray.adjust(lower, upper);  // 점수 조정
                intArray.print();  // 조정된 점수 출력
                pointMenu(stList.length, subject, stList);  // 모든 학생을 대상으로 점수 반영
                break;
            case 2:
                intArray.generate(0, 101);  // 점수 다시 생성
                intArray.print();
                pointMenu(stList.length, subject, stList);  // 모든 학생을 대상으로 점수 반영
                break;
            case 3:
                System.out.println("점수 수정 취소");
                break;
        }
    }

}

