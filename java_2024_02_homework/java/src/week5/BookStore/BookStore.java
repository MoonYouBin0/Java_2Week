package week5.BookStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {
    Scanner scan = new Scanner(System.in);
    static ArrayList<Book> bookList = new ArrayList<>();

    void mymain(){
        readAllBooks();
        printAllBooks();
    }

    void printAllBooks() {
        for(Book b : bookList)
            b.print();
    }

    void readAllBooks() {
        Scanner filein = openFile("book.txt");
        Book b=null;
        int type;
        while(filein.hasNext()){
            type = filein.nextInt();
            switch(type) {
                case 1: b = new Book();
                case 2: b = new Ebook();
            }
            b.read(filein);
            bookList.add(b);
        }
    }

    Scanner openFile(String filename) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (Exception e) {
            System.out.printf("파일 오픈 실패 : %s\n", filename);
            throw new RuntimeException(e);
        }
        return filein;
    }

    public static void main(String[] args){
        BookStore store = new BookStore();
        store.mymain();
    }
}
