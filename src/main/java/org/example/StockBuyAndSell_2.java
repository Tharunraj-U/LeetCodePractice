package org.example;

import java.util.Arrays;

public class StockBuyAndSell_2 {
    class Solution {
        public int maxProfit(int[] p) {
            int  dp[][]=new int[2][p.length];
            Arrays.stream(dp).forEach(e -> Arrays.fill(e,-1));
            return fun(p,0,1,dp);
        }
        int fun(int[] p,int index,int canBuy,int[][] dp){
            if(index == p.length){
                return 0;
            }
            if(dp[canBuy][index] != -1)return dp[canBuy][index];
            int maxP=0;
            if(canBuy ==1){
                int include= -p[index]+fun(p,index+1,0,dp);
                int exclude=fun(p,index+1,1,dp);
                maxP=Math.max(include,exclude);
            }
            else{
                int include=p[index]+fun(p,index+1,1,dp);
                int exclude=fun(p,index+1,0,dp);
                maxP=Math.max(include,exclude);
            }
            dp[canBuy][index]=maxP;
            return maxP;
        }
    }
}
