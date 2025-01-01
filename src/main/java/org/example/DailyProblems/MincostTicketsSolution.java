package org.example.DailyProblems;

import java.util.HashSet;
import java.util.Set;

class MincostTicketsSolution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set=new HashSet<>();
        Integer dp[]=new Integer[366];
         for(int i:days)set.add(i);
        return helper(days[days.length-1],costs,1,set,dp);
    }
    public int helper(int n,int[] costs,int days,Set<Integer> set,Integer dp[]){
       if(days > n)return 0;
       if(dp[days] != null)return dp[days];
        if(!set.contains(days)){
            return dp[days]=helper(n,costs,days+1,set,dp);
        }
       int d1=costs[0]+helper(n,costs,days+1,set,dp);
       int  d2=costs[1]+helper(n,costs,days+7,set,dp);
        int d3=costs[2]+helper(n,costs,days+30,set,dp);
       return dp[days]=Math.min(d1,Math.min(d2,d3));
    }

    public static void main(String[] args) {
       int [] days = {1,4,6,7,8,20};int cost[]={2,7,15};
        System.out.println(new MincostTicketsSolution().mincostTickets(days,cost));
    }
}