package org.example.DailyProblems;

class SolutionMinCostClimbingStairs {
    static int minCostClimbingStairs(int...cost) {
      return hel(cost,cost.length-2,0);
    }
    public static int hel(int cost[],int i,int now){
        if(i == 0){
            return now + cost[0];
        }
        if(i < 0){
            return now;
        }
        int one=Integer.MAX_VALUE;
        if(i-1 >= 0)
        one=hel(cost,i-1,now+cost[i-1]);
        int two=Integer.MAX_VALUE;
        if(i-2 >= 0)  two=hel(cost,i-2,now+cost[i-2]);
        return Math.min(one,two);
    }

    public static void main(String[] args) {
       System.out.println( minCostClimbingStairs(10 ,15, 20));
    }
};