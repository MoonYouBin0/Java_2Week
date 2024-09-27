package week_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    int id, year;
    String name,phone;
    Team t;
    ArrayList<Lecture> registeredList = new ArrayList<>();

    public boolean matchesId(int n){
        return id == n;
    }

    public void read(Scanner scan, Department department) {

        this.id = id;
        name = scan.next();
        phone= scan.next();
        year = scan.nextInt();
    }

    public void print() {
        System.out.printf("%s ",name);
    }

    void setTeam(Team t) {
        Team myteam = t;
    }
}
