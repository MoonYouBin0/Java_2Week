package java_fruit_game;

import java.util.Scanner;
import java.util.Random;

public class game {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    ;
    char[][] ground;

    void game1() {
        int n = scan.nextInt();
        ground = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = rand.nextInt(101);
                ground[i][j] = (n<10) ? '0' : ' ';
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                System.out.printf(" %c", ground[i][j]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        game game = new game();
        game.game1();
    }
}
