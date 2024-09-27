package week_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    ArrayList<Student> stList = new ArrayList<>();
    ArrayList<Team> teamList = new ArrayList<>();
    ArrayList<Lecture> lecList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public Lecture findLecture(String lecName) {
        for (Lecture lec : lecList) {
            if(lec.macheslec(lecName))
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
            if(id == 0)
                break;
            st = new Student();
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

    void printAllTeams() {
        for (Team t : teamList) {
            t.print();
        }
    }

    void reanAllTeams() {
        Team t = null;
        String name;
        while (true) {
            name = scan.next();
            if(name.equals("0"))
                break;
            t = new Team(name);
            t.read(scan, this);
            teamList.add(t);
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
    }

    public static void main(String[] args) {
        Department my = new Department();
        my.mymain();
    }
}
