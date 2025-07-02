package org.example.ZohoLevel_2;

class DaysBetween {
               
    static int Days[]={31,28,31,30,31,30,31,31,30,31,30,31};

    public static  boolean isLeap(int year){
        return (year % 4 == 0 && year % 100 != 0) || year %400 == 0;
    }
    public static int LeapYears(int y,int m){
        if(m <=2){
            y--;
        }
        return (int)((y/4)+(y/400)-(y/100));
    }
    public static int CountDays(int m,int d,int y){
        d+=y*365;
        for(int i=0;i<m-1;i++){
            d+=Days[i];
        }
        d+=LeapYears(y,m);
        return d;
        
    }
    static int noOfDays(int d1, int m1, int y1, int d2, int m2, int y2) {
       return Math.abs(CountDays(m2,d2,y2)-CountDays(m1,d1,y1));
    }
};