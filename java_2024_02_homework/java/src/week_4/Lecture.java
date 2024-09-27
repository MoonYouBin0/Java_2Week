package week_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Lecture {
    String code;
    String lectureName;
    int year;
    String day, time;

    public Lecture(String code) {

    }

    public boolean macheslec(String lecName) {
        return lectureName.equals(lecName);
    }

    public void read(Scanner scan){
        //수강번호 강의명 학년 요일 시간 입력받기
        lectureName = scan.next();
        year = scan.nextInt();
        day = scan.next();
        time = scan.next();
    }

    public void print() {
    }
}
