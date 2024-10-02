package week4_hw;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;
import java.util.ArrayList;

public class Store {
    Scanner scan = new Scanner(System.in);
    ArrayList<Item> itList = new ArrayList<>();
    ArrayList<User> userList = new ArrayList<>();

    void togetherSellStock(){
        int []stock = new int[itList.size()+1];
        Item it = null;
        System.out.print("상품번호또는상품코드: ");
        String kwd = scan.next();
        it = findItem(kwd);
        System.out.printf("[%d]%s와 함께 팔린 상품: \n", it.num, it.name);
        for(User user : userList){
            if(user.numberByUserSearch(kwd)) {
                for (Item item : user.basket) {
                    stock[item.num]++;
                }
            }
        }
        for(int i=3; i>0; i--){
            System.out.printf("%d회: ", i);
            for(int j=0; j<stock.length; j++)
                if(stock[j] == i && j != it.num)
                  System.out.printf("%s ", findItem(""+j).name);
                System.out.println();
        }
    }

    void sellData(){
        int []stock = new int[itList.size()+1];
        System.out.print("상품별판매수, 몇개이상: ");
        int sellStock = scan.nextInt();
        for(User user : userList){
            for(Item it : user.basket){
                stock[it.num]++;
            }
        }
        for(int i=0; i<stock.length; i++){
            if(sellStock<=stock[i]){
                Item it=null;
                it=findItem(""+i);
                System.out.printf("%s - %d개 팔림, %d매출\n", it.name,stock[i], it.price*stock[i]);
            }
        }
    }

    void findUserByItem(){
        Item it = null;
        System.out.print("구매한사용자검색할상품번호또는코드: ");
        String kwd = scan.next();
        it = findItem(kwd);
        it.print();
        for(User user : userList) {
            if(user.numberByUserSearch(kwd)) {
                user.print();
                System.out.println();
            }
        }
    }

    void userNameSearch(){
        System.out.print("사용자검색키워드: ");
       String kwd = scan.next();
       for(User user : userList){
           if(user.matches(kwd)){
               user.print();
           }
       }
    }

    Item findItem(String stock){
        for(Item it : itList){
            if(it.matches(stock)){
                return it;
            }
        }
        return null;
    }

    void itemKeyword(){
        String kwd;
        System.out.print("상품검색 키워드: ");
        kwd = scan.next();
        for(Item it : itList){
            if(it.matches(kwd))
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
        Store store=null;
        User user=null;
        while(true){
            id = scan.next();
            if((id).equals("0"))
                break;
            user = new User(id);
            user.read(scan, this);
            userList.add(user);
        }
    }

    private void printAllItems() {
        for(Item it : itList) {
            it.print();
        }
    }

    void printAllUsers(){
        for(User user : userList){
            user.print();
            System.out.println();
        }
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
                    break;
                case 2 :
                    printAllUsers();
                    System.out.println();
                    break;
                case 3 :
                    itemKeyword();
                    break;
                case 4 :
                    userNameSearch();
                    System.out.println();
                    break;
                case 5 :
                    findUserByItem();
                    break;
                case 6 :
                    sellData();
                    break;
                case 7 :
                    togetherSellStock();
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
