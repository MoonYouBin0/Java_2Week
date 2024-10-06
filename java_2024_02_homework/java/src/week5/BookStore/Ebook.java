package week5.BookStore;

import java.util.Scanner;

public class Ebook extends Book {
    String url;
    String format;

    void read(Scanner scan){
        super.read(scan);
        url = scan.next();
        format = scan.next();
    }

    void print(){

    }

}
