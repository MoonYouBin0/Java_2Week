package week4_hw;

import java.util.ArrayList;
import java.util.Scanner;

public class Item {
    int num, price;
    String code, name;

    public Item(String code) {
        this.code = code;
    }

    public boolean matchesItem(String num){
            if ((""+ this.num).contains(num))
                return true;
            else if((""+price).contains(num))
                return true;
            else if ((code).contains(num))
                return true;
            else if ((name).contains(num))
                return true;
            else
                return false;
    }

    void read(Scanner scan, int num){
        this.num=num;
        name = scan.next();
        price = scan.nextInt();
    }

    void print(){
    System.out.printf("[%d] %s %s (%d원)\n", num, code, name, price);
    }

}
