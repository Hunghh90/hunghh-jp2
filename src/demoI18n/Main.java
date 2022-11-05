package demoI18n;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args){
        Locale vi = new Locale("vi","VN");
        Locale en = new Locale("en","US");
        Locale.setDefault(vi);
        ResourceBundle rb1 = ResourceBundle.getBundle("demoI18n.message",en);
        ResourceBundle rb2 = ResourceBundle.getBundle("demoI18n.message");
        System.out.println(rb1.getString("hello"));
        System.out.println(rb2.getString("hello"));


    }
}
