import java.text.*;
import java.util.*;

public class BusinessDayAdder {

    public static void main(String[] args) throws Exception {
        // Sample Input
        String inputDate = "6th June,2025";
        int businessDaysInWeek = 5;
        int businessDaysToAdd = 2;

        // Process and print result
        String result = addBusinessDays(inputDate, businessDaysInWeek, businessDaysToAdd);
        System.out.println(result);
    }

    public static String addBusinessDays(String inputDate, int businessDaysInWeek, int daysToAdd) throws Exception {
        // Remove "st", "nd", "rd", "th" from date
        inputDate = inputDate.replaceAll("(\\d+)(st|nd|rd|th)", "$1");

        // Parse input date

        Date date = new SimpleDateFormat("d MMMM,yyyy",Locale.ENGLISH).parse(inputDate);


        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
      //  System.out.println(Calendar.DAY_OF_MONTH);

        while (daysToAdd > 0) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

            if (businessDaysInWeek == 5) {
                // Business days: Mon-Fri (1=Sunday, 7=Saturday)
                if (dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY) {
                    daysToAdd--;
                }
            } else if (businessDaysInWeek == 6) {
                // Business days: Mon-Sat (only Sunday is off)
                if (dayOfWeek != Calendar.SUNDAY) {
                    daysToAdd--;
                }
            }
        }
        // Format output with suffix (1st, 2nd, 3rd, 4th...)
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String suffix = getDaySuffix(day);
        String monthYear = new SimpleDateFormat("MMMM,yyyy", Locale.ENGLISH).format(cal.getTime());
        System.out.println(day);
        return day + suffix + " " + monthYear;
    }

    public static String getDaySuffix(int day) {
        if (day >= 11 && day <= 13) return "th";
        switch (day % 10) {
            case 1:  return "st";
            case 2:  return "nd";
            case 3:  return "rd";
            default: return "th";
        }
    }
}
