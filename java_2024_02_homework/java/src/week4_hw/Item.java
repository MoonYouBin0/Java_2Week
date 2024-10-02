package week4_hw;

import java.util.ArrayList;
import java.util.Scanner;

public class Item {
    int num, price;
    String code, name;

    public Item(String code) {
        this.code = code;
    }

    boolean matches(String stock){
        if((""+this.num).equals(stock))
            return true;
        else if((""+price).equals(stock))
            return true;
        else if ((code).equals(stock))
            return true;
        else if ((name).equals(stock))
            return true;
        else
            return false;
    }


    void read(Scanner scan, int num){
        this.num=num;
        this.price = price;
        name = scan.next();
        price = scan.nextInt();
    }

    void print(){
        System.out.printf("[%d] %s %s (%d원)\n", num, code, name, price);
    }

}
