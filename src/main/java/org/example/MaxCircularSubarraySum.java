package org.example;

public class MaxCircularSubarraySum {
    public int circularSubarraySum(int arr[]) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int curMax=0,curMin=0,ts=0;
        for(int a : arr){

            curMax=Math.max(a,curMax+a);
            max=Math.max(max,curMax);


            curMin=Math.min(a,curMin+a);
            min=Math.min(min,curMin);
            ts+=a;
        }
        if(max < 0){
            return max;
        }
        return Math.max(max,ts-min);
    }
}


