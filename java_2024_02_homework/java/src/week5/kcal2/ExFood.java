package week5.kcal2;

import java.util.Scanner;

public class ExFood extends Food {
    String weight;
    String unit2;

    void read(Scanner scan) {
        super.read(scan);
        weight = scan.next();
        unit = scan.next();
    }

    void printNoLn() {
        // 빵-샌드위치 (468kcal/개)
        System.out.format("%s-%s (%dkcal/%s) %s %s", type, name, cal, unit, weight, unit2);
    }
}