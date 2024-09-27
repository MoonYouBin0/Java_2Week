package week3;

import java.util.Scanner;

public class Student {
    int id, year, score;
    public String name;
    String number;


    boolean matches(String kwd) {
        if (kwd.chars().allMatch(Character::isDigit)) {
            if (kwd.length() == 1) {
                if ((""+year).contains(kwd))
                    return true;
            } else {
                if ((""+id).contains(kwd) || number.contains(kwd))
                    return true;
            }
        } else {
            if (name.contains(kwd))
                return true;
        }
        return false;
    }

    boolean matches(String[] kwds) {
        for (String kwd : kwds) {
            if (kwd.startsWith("-")) {
                String excludeKwd = kwd.substring(1);
                if (matches(excludeKwd)) {
                    return false;
                }
            } else {
                if (!matches(kwd)) {
                    return false;
                }
            }
        }
        return true;
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

    public boolean matchesId(int n) {
        return false;
    }
}
