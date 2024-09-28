package week_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Lecture {
    String code;
    String lectureName;
    int year;
    String day, time;

    public Lecture(String code) {
        this.code = code;
    }

    public boolean macheslec(String code) {
        return ((this.code).equals(code));
    }

    public void read(Scanner scan){
        //수강번호 강의명 학년 요일 시간 입력받기
        lectureName = scan.next();
        year = scan.nextInt();
        day = scan.next();
        time = scan.next();
    }

    public void print() {
        System.out.printf("\t[%s] %s %d학년 (%s %s)\n", code, lectureName, year, day, time);
    }
}
