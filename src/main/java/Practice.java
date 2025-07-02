import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Practice {

    public static void main(String[] args) throws Exception {
        String inputDate = "22nd June,2025";
        int businessDaysInWeek = 5;
        int businessDaysToAdd = 7;
       String ans=fun(inputDate,businessDaysInWeek,businessDaysToAdd);
       System.out.println(ans);


    }
    public static String fun(String inputDate, int businessDaysInWeek, int businessDaysToAdd)throws Exception{
       inputDate=inputDate.replaceAll("(\\d+)(st|nd|rd|th)","$1");

        Date date= new SimpleDateFormat("dd MMM,yyyy",Locale.ENGLISH).parse(inputDate);

        Calendar calender= Calendar.getInstance();
        calender.setTime(date);

        while(businessDaysToAdd > 0) {
            calender.add(Calendar.DAY_OF_MONTH, 1);
            businessDaysInWeek = calender.get(Calendar.DAY_OF_WEEK);

            if (businessDaysInWeek == 5) {
                if (businessDaysInWeek >= Calendar.MONDAY && businessDaysInWeek <= Calendar.SATURDAY)
                    businessDaysToAdd--;
            } else if (businessDaysInWeek == 6) {
                if (businessDaysInWeek != Calendar.SUNDAY) {
                    businessDaysToAdd--;
                }
            }
        }
        String ans = new SimpleDateFormat("MMMM,yyyy", Locale.ENGLISH).format(calender.getTime());
        int d=calender.get(Calendar.DAY_OF_MONTH);
        String suffix=getdsuffix(d);
        return d + suffix + ans;
    }

    public static String getdsuffix(int d){
        if(d >= 11 && d <= 13)return "th";
        switch (d%10){
            case 1: return "st";
            case 2:return "nd";
            case 3: return "rd";
            case 4: return "th";
            default  : return "th";
        }

    }
}