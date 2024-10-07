package week5.Kcal;

import java.util.Scanner;

public class ExFood extends Food {
    String weight;
    String unit2;

    void read(Scanner scan) {
        super.read(scan);
        weight = scan.next();
        unit2 = scan.next();
    }

    void printNoLn() {
        System.out.format("%s-%s (%dkcal/%s) %s %s", type, name, cal, unit, weight, unit2);
    }

    void printEat(int n, String u) {
        int baseKcal = cal;
        int weightVal = Integer.parseInt(weight.split(" ")[0]);
        int kcal = getKcal(n, u);

        System.out.format("%s %d%s(%dkcal)", name, n, u, kcal);
        if (u.equals(unit2)) {
            System.out.format(" - %dkcal/%d%s -> %dkcal*%d/%d%s=%dkcal", baseKcal, weightVal, unit2, baseKcal, n, weightVal, unit2, kcal);
        } else if (!u.equals(unit)) {
            System.out.format(" - %dkcal/%d%s", baseKcal, 1, unit);
        }
        System.out.println();
    }

    int getKcal(int n, String u) {
        if (u.equals(unit2)) {
            return (n * cal) / Integer.parseInt(weight.split(" ")[0]);
        }
        return super.getKcal(n, u);
    }

}
