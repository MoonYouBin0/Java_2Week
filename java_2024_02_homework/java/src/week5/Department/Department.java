package week5.Department;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static jdk.jfr.consumer.EventStream.openFile;

public class Department {
    Scanner scan = new Scanner(System.in);
    ArrayList<Student> studentList = new ArrayList<>();
    static ArrayList<Lecture> lectureList = new ArrayList<>();


    void run() {
        readLectures();
        printLectures();
        readStudents();
        printStudents();
        search();
    }

//    private void readAll(String filename) {
//        Scanner filein = openFile(filename);
//        while(filein.hasNext()){
//            String id = filein.next();
//            Student st = new Student();
//            st.read(filein);
//            studentList.add(st);
//        }
//        filein.close();
//    }

    Scanner openFile(String filename) {
        Scanner filein=null;
            try {
                filein = new Scanner(new File(filename));
            } catch (FileNotFoundException e) {
                System.out.printf("파일 오픈 실패 : %s\n", filename);
                throw new RuntimeException(e);
            }
        return filein;
    }

    private void printLectures() {
        // TODO Auto-generated method stub
        for (Lecture lec: lectureList) {
            lec.print();
        }
    }

    void readStudents() {
        Scanner filein = openFile("input1.txt");
        Student st = null;
        while (filein.hasNext()) {
            st = new Student();
            st.read(filein);
            studentList.add(st);
            st.print();
        }
    }
    void readLectures() {
        Scanner filein = openFile("Lecture.txt");
        Lecture lec = null;
        while (filein.hasNext()) {
            lec = new Lecture();
            lec.read(filein);
            lectureList.add(lec);
        }
    }

    void printStudents() {
        for (Student st : studentList) {
            st.print();
        }
    }

    void search() {
        String name = null;
        while (true) {
            System.out.print("키워드:");
            name = scan.next();
            if (name.equals("end"))
                break;
            for (Student st : studentList) {
                if (st.matches(name))
                    st.print();
            }
        }
    }

    public static void main(String args[]) {
        Department my = new Department();
        my.run();
    }

    static public Lecture findLecture(String code) {
        // TODO Auto-generated method stub
        for (Lecture lec: lectureList) {
            if (lec.matches(code))
                return lec;
        }
        return null;
    }
}