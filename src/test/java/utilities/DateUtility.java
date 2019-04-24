package utilities;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class DateUtility {

    public static void main(String[] args) {
        System.out.println(todaysDate());
        System.out.println(getLocalDateFromClock());

    }

    public static String todaysDate(){
        String today=new SimpleDateFormat("MMMM dd, yyy").format(new Date());
        return today;
    }

    public static LocalDate getLocalDateFromClock() {
        return LocalDate.now();
    }


}
