package week4_hw;

import java.util.Scanner;
import java.util.ArrayList;

public class User {
    String id, pwd;
    int stock;
    Scanner scan = new Scanner(System.in);
    ArrayList<Item> basket = new ArrayList<>();
    int price=0;

    public User(String id) {
        this.id = id;
    }

    void read(Scanner scan){
        Item it = null;
        pwd = scan.next();
        while(true) {
            stock = scan.nextInt();
            if (stock == 0)
                break;
        }
    }

    void print(){
        //System.out.print("[%s] 총구매 %d건 %d원 (%d점)", id, basket.length(),);
    }
}
