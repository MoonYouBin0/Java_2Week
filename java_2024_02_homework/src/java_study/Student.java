package java_study;

import java.util.Scanner;

public class Student {
    int id, year, score;
    String name,number;

    boolean matches(String kwd){
        if(name.contains(kwd))
            return true;
        if((""+id).contains(kwd))
            return true;
        if((""+year).contains(kwd))
            return true;
        if((""+score).contains(kwd))
            return true;
        if((""+number).contains(kwd))
            return true;
        return false;
    }

    public void read(Scanner scan, int id) {
        this.id = id;
        name = scan.next();
        year = scan.nextInt();
        number = scan.next();
        score = scan.nextInt();
    }

    public void print() {
        System.out.printf("%d %s (%d학년) %s - %d점", id, name, year, number, score);
        System.out.println();
    }

}
