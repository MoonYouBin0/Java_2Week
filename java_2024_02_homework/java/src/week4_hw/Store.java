package week4_hw;

import java.util.Scanner;
import java.util.ArrayList;

public class Store {
    Scanner scan = new Scanner(System.in);
    ArrayList<Item> itList = new ArrayList<>();
    ArrayList<User> userList = new ArrayList<>();

    Item findItem(String num){
        for(Item it : itList){
            if(it.matchesItem(num)) {
                return it;
            }
        }
        return null;
    }

    void findItemSearch(){

    }

    void itemKeyword(String kwd){
        System.out.print("상품검색 키워드: ");
        kwd = scan.next();
        for(Item it : itList){
            if(it.matchesItem(kwd))
                it.print();
        }
    }

    private void readAllItems() {
        int num=1;
        String code;
        Item it = null;
        while(true){
           code = scan.next();
           if((code).equals("0"))
               break;
           it = new Item(code);
            it.read(scan, num);
            itList.add(it);
            num++;
        }
    }

    private void readAllUsers() {
        String id;
        User user=null;
        while(true){
            id = scan.next();
            if((id).equals("0"))
                break;
            user = new User(id);
            user.read(scan);
            userList.add(user);
        }
    }

    private void printAllItems() {
        for(Item it : itList) {
            it.print();
            System.out.println();
        }
    }

    private void printAllUsers() {
    }

    private void menu() {
        int n=0;
        String kwd=null;
        while(true){
            System.out.print("(1) 상품출력 (2) 사용자출력 (3) 삼품검색 (4) 사용자검색\n(5) 상품으로사용자검색 (6) 상품별판매현황 (7) 같이 판매된상품\n(0) 종료 => ");
            n = scan.nextInt();
            switch(n){
                case 0 :
                    break;
                case 1 :
                    printAllItems();
                    System.out.println();
                    break;
                case 2 :
                    break;
                case 3 :
                    itemKeyword(kwd);
                    break;


            }
            if(n==0)
                break;
        }
    }

    void mymain(){
        readAllItems();
        readAllUsers();
        menu();
    }

    public static void main(String[] args){
        Store my = new Store();
        my.mymain();
    }
}
