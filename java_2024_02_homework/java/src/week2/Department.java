package week2;

import java.util.Scanner;

public class Department {
    Scanner scan = new Scanner(System.in);
    int n;
    Student[] stList;

    void mymain() {
        System.out.print("학생 수: ");
        n = scan.nextInt();
        stList = new Student[n];

        // 학생 정보 입력
        for (int i = 0; i < n; i++) {
            stList[i] = new Student();
            stList[i].read(scan);
        }

        // 학생 정보 출력
        for (Student st : stList) {
            st.print();
        }

        // 점수 수정 메뉴 시작
        startMenu(n, stList);  // 수정된 부분: 한 번만 호출
    }

    // startMenu를 한 번만 호출
    void startMenu(int n, Student[] stList) {
        String answer = "y";
        while (true) {
            System.out.print("계속 하시겠습니까? (y/n): ");
            answer = scan.next();
            if (answer.equals("y")) {
                stList[0].menu(n, stList);  // 첫 번째 학생 기준으로 메뉴 호출
            } else if (answer.equals("n")) {
                System.out.println("안녕히 가세요.");
                break;  // 루프 종료
            }
        }
    }

    public static void main(String[] args) {
        Department my = new Department();
        my.mymain();
    }
}

