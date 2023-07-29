package util;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class RandomDateGenerator {
public  Date getDate()
    {
        Random random= new Random();
        Calendar calender = Calendar.getInstance();
        Date now = new Date();
        int daysToSubstract = -1 * random.nextInt(2 * 365);
        calender.setTime(now);
        calender.add(Calendar.DAY_OF_YEAR, daysToSubstract);
        Date yesterday = calender.getTime();
        return yesterday;

    }

    public static void main(String[] args) {
        RandomDateGenerator rd= new RandomDateGenerator();
        System.out.println(rd.getDate());
    }
}
