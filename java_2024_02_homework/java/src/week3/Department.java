package week3;

import java.util.Scanner;
import java.util.ArrayList;

public class Department {
    ArrayList<Student> stList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    void integrated(){
        String kwd = null;
        Student st = null;
        while(true){
            System.out.printf("통합검색 키워드: ");
            kwd = scan.next();
            if(kwd.equals("end"))
                break;
            for(int i=0; i<stList.size(); i++){
                st = findStudent(kwd);
                if(st != null) {
                    st.print();
                }
                else if(st == null)
                    break;

            }
        }
    }

    Student findStudent(String kwd) {
        for(Student st : stList) {
            if (st.matches(kwd))
                return st;
        }
        return null;
    }

    void serch(){
        String name = null;
        Student st = null;
        while(true){
            System.out.printf("이름: ");
            name = scan.next();
            if(name.equals("end"))
                break;
            st = findStudent(name);
                if(st != null){
                    st.print();
                    break;
                }

        }
    }

    void menu(){
        while(true){
            System.out.print("(1) 전체출력 (2) 이름검색 (3) 통합검색 (4) 점수겁색 (5) 종료\n");
            switch(scan.nextInt()){
                case 1 :
                    printAll();
                    break;
                case 2 :
                    serch();
                    break;
                case 3 :
                    integrated();

            }
        }
    }

    void readAll() {
        int id;
        Student st;
        while (true) {
            id = scan.nextInt();
            if(id == 0)
                break;
            st = new Student();
            st.read(scan, id);
            stList.add(st);
        }
    }

    void printAll() {
        for (Student st : stList) {
            st.print();
        }
    }

    void mymain() {
        readAll();
        printAll();
        menu();
    }

    public static void main(String[] args) {
        Department my = new Department();
        my.mymain();
    }
}
