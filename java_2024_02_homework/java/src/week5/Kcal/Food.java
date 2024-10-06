package week5.Kcal;

import java.util.Scanner;

public class Food {
	String type;
	String name;
	String unit;
	int cal;

	void read(Scanner scan) {
		type = scan.next();
		name = scan.next();
		unit = scan.next();
		cal = scan.nextInt();
	}

	void printNoLn() {
		System.out.format("%s-%s (%dkcal/%s)", type, name, cal, unit);
	}

	void print() {
		printNoLn();
		System.out.println();
	}

	void printEat(int n, String u) {
		int kcal = getKcal(n, u);
		System.out.format("%s %d%s(%dkcal)", name, n, u, kcal);
		if (!u.equals(unit)) {
			int baseKcal = cal;
			System.out.format(" - %dkcal/%d%s -> %dkcal*%d/%d%s=%dkcal", baseKcal, 1, unit, baseKcal, n, 1, u, kcal);
		}
		System.out.println();
	}

	int getKcal(int n, String u) {
		return n * cal;
	}

	public boolean matches(String name) {
		return this.name.equals(name);
	}
}
