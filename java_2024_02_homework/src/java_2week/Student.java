package java_2week;

import java.util.Scanner;

public class Student {
        int id;
        String name;
        int year;
        int score[] = new int[3];
        char grade[] =new char[3];

        void read(Scanner scan) {
            id = scan.nextInt();
            name = scan.next();
            year = scan.nextInt();
            for(int i=0; i<3; i++){
                score[i] = scan.nextInt();
                switch(score[i]/10){
                    case 10:
                    case 9:
                        grade[i] = 'A';
                        break;
                    case 8:
                        grade[i] = 'B';
                        break;
                    case 7:
                        grade[i] = 'C';
                        break;
                    case 6:
                        grade[i] = 'D';
                        break;
                    default:
                        grade[i] = 'F';
                        break;
                }
            }
        }
        void print(){
            System.out.printf("%d %s %d학년 %d(%c) %d(%c) %d(%c)\n", id, name, year, score[0],grade[0], score[1],grade[1], score[2], grade[2]);
        }
}
