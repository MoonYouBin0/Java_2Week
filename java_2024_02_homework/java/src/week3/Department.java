package week3;

import java.util.Scanner;
import java.util.ArrayList;

public class Department {
    ArrayList<Student> stList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);


    void multiKeywordSearch() {
        String line;
        String[] kwdArr;

        while (true) {
            System.out.print("검색 키워드 여러개(빈칸으로 구분): ");
            line = scan.nextLine().trim();


            if (line.isEmpty()) {
                continue;
            } else if (line.equalsIgnoreCase("end")) {
                break;
            }

            kwdArr = line.split(" ");
            for (Student st : stList) {
                if (st.matches(kwdArr)) {
                    st.print();
                }
            }
        }
    }

    void menu() {
        while (true) {
            System.out.print("(1) 전체출력 (2) 이름검색 (3) 통합검색 (4) 점수검색 (5) 멀티 키워드 검색 (6) 종료\n");

            if (!scan.hasNextInt()) {
                System.out.println("유효한 숫자를 입력하세요.");
                scan.nextLine(); // 잘못된 입력 소비
                continue; // 다시 입력 받기
            }

            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    printAll();
                    break;
                case 2:
                    serch();
                    break;
                case 3:
                    integratedSerch();
                    break;
                case 4:
                    scoreSearch();
                    break;
                case 5:
                    multiKeywordSearch();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
    }


    void scoreSearch() {
        System.out.print("점수 검색 범위: ");
        String input = scan.nextLine().trim();

        try {
            if (input.contains("-")) {
                if (input.startsWith("-")) {
                    int upperBound = Integer.parseInt(input.substring(1));
                    for (Student st : stList) {
                        if (st.score < upperBound) {
                            st.print();
                        }
                    }
                } else if (input.endsWith("-")) {
                    int lowerBound = Integer.parseInt(input.substring(0, input.length() - 1));
                    for (Student st : stList) {
                        if (st.score >= lowerBound) {
                            st.print();
                        }
                    }
                } else {
                    String[] bounds = input.split("-");
                    if (bounds.length == 2) {
                        int lowerBound = Integer.parseInt(bounds[0]);
                        int upperBound = Integer.parseInt(bounds[1]);
                        for (Student st : stList) {
                            if (st.score >= lowerBound && st.score < upperBound) {
                                st.print();
                            }
                        }
                    } else {
                        System.out.println("잘못된 구간 입력입니다.");
                    }
                }
            } else if (input.contains(" ")) {
                String[] bounds = input.split(" ");
                if (bounds.length == 2) {
                    int lowerBound = Integer.parseInt(bounds[0]);
                    int upperBound = Integer.parseInt(bounds[1]);
                    for (Student st : stList) {
                        if (st.score >= lowerBound && st.score < upperBound) {
                            st.print();
                        }
                    }
                } else {
                    System.out.println("잘못된 구간 입력입니다.");
                }
            } else {
                int exactScore = Integer.parseInt(input);
                for (Student st : stList) {
                    if (st.score == exactScore) {
                        st.print();
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("유효한 숫자가 아닙니다.");
        }
    }

    void integratedSerch() {
        String kwd = null;
        Student st = null;
        System.out.printf("통합검색 키워드: ");
        kwd = scan.next();
        findStudent(kwd, 1);
    }

    void findStudent(String kwd, int s) {
        for (Student st : stList) {
            if (st.matches(kwd))
                st.print();
        }
    }

    Student findStudent(String kwd) {
        for (Student st : stList) {
            if (st.matches(kwd))
                return st;
        }
        return null;
    }

    void serch() {
        String name = null;
        Student st = null;
        while (true) {
            System.out.printf("이름: ");
            name = scan.next();
            if (name.equals("end"))
                break;
            st = findStudent(name);
            if (st != null) {
                st.print();
                break;
            }
        }
    }

    void readAll() {
        int id;
        Student st;
        while (true) {
            id = scan.nextInt();
            if (id == 0)
                break;
            st = new Student();
            st.read(scan, id);
            stList.add(st);
        }
    }

    void printAll() {
        for (Student st : stList) {
            st.print();
        }
    }

    void mymain() {
        readAll();
        printAll();
        menu();
    }

    public static void main(String[] args) {
        Department my = new Department();
        my.mymain();
    }
}
