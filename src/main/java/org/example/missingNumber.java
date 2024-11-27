package org.example;

import java.util.Arrays;

public class missingNumber {
    public int missingNumber(int...arr) {
        int min= Arrays.stream(arr).min().getAsInt();
        int max=Arrays.stream(arr).max().getAsInt();
        if(max <=0 && min <=0){
            return 1;
        }
        if(min < 0){
            min=-1;
        }
        Arrays.sort(arr);
        int j=0;
        for(int i=min+1;i<max;i++){
            if(!isPresent(arr,arr[j++])){
                return arr[j];
            }
        }
        return 1;
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
        new missingNumber().missingNumber(1 ,2 ,3, 4, 5);
    }
}
