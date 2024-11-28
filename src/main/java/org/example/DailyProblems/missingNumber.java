package org.example.DailyProblems;

import java.util.Arrays;

public class missingNumber {
    public int missingNumber(int... arr) {

        Arrays.sort(arr);
        int max=arr[arr.length-1];
        int min=arr[0];
        if(min > 1 || (min < 0 && max <0)){
            return 1;
        }
        if(min < 0 ){
            min=0;
        }


        for(int i=min+1;i<max;i++){
            if(!isPresent(arr,i)){
                return i;
            }
        }
        return max+1;
    }
    public boolean isPresent(int[] arr,int val){
        int l=0;
        int r=arr.length-1;
        while(l<=r){
            int mid=(l+(r-l)/2);
            if(arr[mid]==val){
                return true;
            }else if( val > arr[mid]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new missingNumber().missingNumber(-1,-2,1,2, 8 ,3, 4, 5));
    }
}
