import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Practice {

    public static void main(String[] args) throws ParseException {
        String s="24th june,2015";
        int w=5;
        int days=10;


        s=s.replaceAll("(\\d+)(rd|th|nd|st)","$1");


        Date date=new SimpleDateFormat("d MMMM,yyyy", Locale.ENGLISH).parse(s);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);

        while (days >0){
            calendar.add(Calendar.DAY_OF_MONTH,1);
            int currDay=calendar.get(Calendar.DAY_OF_WEEK);
            if(w ==6) {
                if (currDay != Calendar.SUNDAY) {
                    days--;
                }
            }else if( w == 5){
                if (currDay >= Calendar.MONDAY && currDay <= Calendar.FRIDAY) {
                    days--;
                }
            }
        }


        int day1=calendar.get(Calendar.DAY_OF_MONTH);
        String day2=fun(day1);



        String ans=new SimpleDateFormat(" MMMM,yyyy",Locale.ENGLISH).format(calendar.getTime());
        System.out.println(day2+ans);


    }

    private static String fun(int day1) {
        if(day1 >=11 && day1 <=20)return  day1+"th";
        switch (day1%10){
            case 1: return day1+"st";
            case 2:return  day1+"nd";
            case 3: return day1+"rd";
            default: return day1+"th";
        }
    }
}