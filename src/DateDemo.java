import java.util.*;
import java.text.*;

public class DateDemo {
    public static void main(String args[]) {

        Date now = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");

        System.out.println("Current Date: " + ft.format(now));

        //Current Date: 火 2016.11.01 at 01:37:56 午後 CST
    }
}