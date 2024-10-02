package week4_hw;

import java.util.Scanner;
import java.util.ArrayList;

public class User {
    String id, pwd, stock;
    int point =0;
    int basketPrice;
    int tn=-1;
    Scanner scan = new Scanner(System.in);
    ArrayList<Item> basket = new ArrayList<>();
    int price=0;

    public User(String id) {
        this.id = id;
    }

    boolean numberByUserSearch(String kwd){
        for(Item it : basket){
            if(it.matches(kwd))
                return true;
        }
        return false;
    }

    boolean matches(String kwd){
        if((kwd).equals(id))
            return true;
        return false;
    }

    void read(Scanner scan, Store store){
        Item it = null;
        pwd = scan.next();
        point = scan.nextInt();
        while(true) {
            stock = scan.next();
            tn++;
            if((stock).equals("0"))
                break;
            it = store.findItem(stock);
            basketPrice += it.price;
            point += it.price/100;
            basket.add(it);
        }
    }

    void print(){
        System.out.printf("[%s] 총구매 %d건 %d원 (%d점)\n", id, tn++, basketPrice, point);
        for(Item it : basket) {
            System.out.printf("%s ", it.name);
        }
    }
}