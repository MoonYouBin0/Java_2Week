package week5.Department;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    String name,code;
    int id;
    String phone;
    int year;
    ArrayList<Lecture> registeredList = new ArrayList<>();

    void read(Scanner scan) {
        this.id = scan.nextInt();
        name = scan.next();
        phone = scan.next();
        year = scan.nextInt();
        Lecture lec=null;
        while(true){
            code = scan.next();
            if((code).equals("0")) {
                break;
            }
            lec = Department.findLecture(code);
            registeredList.add(lec);
        }
    }

    void print() { // Student
        System.out.format("%d %s %s (%d학년)\n", id, name, phone, year);
        for (Lecture mylec : registeredList) {
            System.out.print("\t");
            mylec.print();
        }
    }

    boolean matches(String kwd) {
        // TODO Auto-generated method stub
        if (name.contentEquals(kwd))
            return true;
        return ("" + id).contentEquals(kwd);
    }
}
