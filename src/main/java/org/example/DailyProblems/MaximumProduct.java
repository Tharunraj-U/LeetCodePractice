package org.example.DailyProblems;

import java.util.Arrays;

public class MaximumProduct {
    int maxProduct(int ...arr) {
        int dp[]=new int[arr.length];
        Arrays.fill(dp,-1);
        return helper(arr,0,Integer.MIN_VALUE,dp);
    }
    public int   helper(int[] arr,int i,int max,int[] dp){
        if( i == arr.length-1){
            return max;
        }
        if(i > 0){
            int i1 = dp[i - 1]/arr[i-1];
            return  dp[i]=i1;
        }
        int thisMax=1;
        for(int j=i;j<arr.length;j++){
            if(arr[j] == 0)break;
            thisMax*=arr[j];
        }
        max=Math.max(max,thisMax);
        dp[i]=thisMax;
        return Math.max(max,helper(arr,i+1,max,dp));
    }


    public static void main(String[] args) {
        System.out.println(new MaximumProduct().maxProduct(2, 3, 4));
        System.out.println(new MaximumProduct().maxProduct(-1, -3, -10, 0, 6));
        System.out.println(new MaximumProduct().maxProduct(-2, 6, -3, -10, 0, 2));
    }
}
