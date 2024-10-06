package extends_JavaEx;

public class TvChannel extends Tv {
    boolean caption;
    void displayCaption(String text){
        if(caption)
            System.out.println(text);

    }
}
