package week5.kcal2;

import java.util.Scanner;

public class ExFood extends Food {
    int weight;
    String unit2;

    void read(Scanner scan) {
        super.read(scan);
        weight = scan.nextInt();
        unit2 = scan.next();
    }

    void printNoLn() {
        // 빵-샌드위치 (468kcal/개)
        System.out.format("%s-%s (%dkcal/%s) %d %s", type, name, cal, unit, weight, unit2);
    }

    void printEat(int n, String u) {
        // 우유 100ml(0kcal) - 125kcal/1개
        System.out.format("%s %d%s(%dkcal)", name, n, u, getKcal(n, u));
        System.out.format(" - %dkcal/%d%s", cal, 1, unit);
        if((u).equals("g") || (u).equals("cc")||(u).equals("ml"))
            printDetail(n, u);
        System.out.println();
    }

    int getKcal(int n, String u) {
            return cal*n/weight;
    }

    void printDetail(int n, String u) {
        System.out.printf("(%d) -> %dkcal*%d/%d%s=%dkcal",weight, cal, n, weight, unit2, getKcal(n,u));
    }
}