package week_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {
    String name;
    ArrayList<Student> members = new ArrayList<Student>();
    Scanner scan = new Scanner(System.in);

    public Team(String name) {
        this.name = name;
    }


    public void read(Scanner scan, Department department) {
        int n;
        Student st = null;
        while(true) {
            n = scan.nextInt();
            if (n == 0)
                break;
            st = department.findStudent(n);
            members.add(st);
        }
    }

    public void print(){
        for(Student st : members)
            st.print();
        System.out.println();
    }
}
