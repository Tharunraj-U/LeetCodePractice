package org.example.ZohoLevel_2;

class FinalDestination
 {
    static int canReach(Long a, Long b, Long x) {
        long min=Math.abs(a)+Math.abs(b);
        if(min > x)return 0;
        if((x-min)%2  == 0 )return 1;
        return 0;
    }
};