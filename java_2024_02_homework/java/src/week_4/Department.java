package week_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    ArrayList<Student> stList = new ArrayList<>();
    ArrayList<Lecture> lecList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public Lecture findLecture(String code) {
        for(Lecture lec : lecList){
            if(lec.macheslec(code))
                return lec;
        }
        return null;
    }

    public Student findStudent(int n) {
        for(Student st : stList) {
            if (st.matchesId(n))
                return st;
        }
        return null;
    }

    void readAllStudent() {
        int id;
        Student st;
        while (true) {
            id = scan.nextInt();
            if(id==0)
                break;
            st = new Student(id);
            st.read(scan, this);
            stList.add(st);
        }
    }

    void printAlllecture() {
        for (Lecture lec : lecList) {
            lec.print();
        }
    }

    void printAllStudent() {
        for (Student st : stList) {
            st.print();
        }
    }

    private void readAllLecture() {
        Lecture lec = null;
        String code;
        while (true) {
            code = scan.next();
            if(code.equals("end"))
                break;
            lec = new Lecture(code);
            lec.read(scan);
            lecList.add(lec);
        }
    }

    void mymain() {
        readAllLecture();
        readAllStudent();
        printAllStudent();
    }

    public static void main(String[] args) {
        Department my = new Department();
        my.mymain();
    }
}
