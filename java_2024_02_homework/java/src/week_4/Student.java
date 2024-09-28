package week_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    int id, year;
    String name,phone;
    ArrayList<Lecture> registeredList = new ArrayList<>();

    public Student(int id){
        this.id = id;
    }

    public boolean matchesId(int n){
        return id == n;
    }

    public void read(Scanner scan, Department department) {
        String code=null;
        Lecture lec = null;
        name = scan.next();
        phone= scan.next();
        year = scan.nextInt();
        //lecture 비교?
        while(true){
            code = scan.next();
            if((code).equals("0"))
                break;
            lec = department.findLecture(code);
            registeredList.add(lec);
        }
    }

    public void print() {
        System.out.printf("%s %s %s (%d학년)\n",id, name, phone, year);
        for(Lecture lec : registeredList)
            lec.print();
    }
}
