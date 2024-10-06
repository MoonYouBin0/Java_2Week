package week5.BookStore;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    String title;
    String pub;
    String isbn;
    int year, price;
    String tok;
    ArrayList<String> authors = new ArrayList<>();

    void read(Scanner scan){
        Book b= null;
        title = scan.next();
        pub = scan.next();
        isbn = scan.next();
        year = scan.nextInt();
//        tok = scan.next();
        while(true){
            String author = scan.next();
            if((author).equals("0"))
                break;
            authors.add(author);
        }
        price = scan.nextInt();
    }

    void print(){
        System.out.printf("%s %s %s %d",title, pub, isbn, year);
        for(String a : authors)
            System.out.printf("%s",authors);
        System.out.printf("%d", price);
    }

//    boolean matches(String kwd){
//        return false;
//    }

}
