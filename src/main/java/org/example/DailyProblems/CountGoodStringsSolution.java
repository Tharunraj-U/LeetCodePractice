package org.example.DailyProblems;

import java.util.Arrays;

class CountGoodStringsSolution {
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[]=new int[high+1];
        Arrays.fill(dp,-1);
         return helper(low,high,zero,one,0,dp);
     
    }
    public int  helper(int low,int high,int z,int o,int n,int[] dp){
        if( n > high)return  0;
        if(dp[n] != -1)return dp[n];
        int c=0;
        if(n >= low )c++;
        c+=helper(low,high,z,o,n+z,dp);
        c+=helper(low,high,z,o,n+o,dp);
        c%=1000000007;
        return  dp[n]=c;
          
    }
}