package ntime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class LocalDateAndTimeTest {
    public static void main(String[] args){
        LocalDate date = LocalDate.of(2018,6,24);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
        System.out.println(year+"\n"+month+"\n "+ day +" \n " + dayOfWeek + " \n " + len + "\n " + leap);
    }
}
