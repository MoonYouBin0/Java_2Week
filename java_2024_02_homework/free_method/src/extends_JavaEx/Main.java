package extends_JavaEx;

public class Main {
    public static void main(String[] args){
        TvChannel tv = new TvChannel();
        tv.channel = 10;
        tv.channelUp();
        System.out.println(tv.channel);
        tv.displayCaption("Hello, Java");
        tv.caption = true;
        tv.displayCaption("exectly");
    }
}
