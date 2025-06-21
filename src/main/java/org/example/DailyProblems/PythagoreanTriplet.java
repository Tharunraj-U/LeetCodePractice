package org.example.DailyProblems;

import java.util.Arrays;

class PythagoreanTriplet {
    static boolean pythagoreanTriplet(int... arr) {
        for(int i=0;i<arr.length;i++){
            arr[i]*=arr[i];
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length-3;i++){
             while(i>0 && arr[i] ==arr[i-1])i++;
             int j=i+1,k=arr.length-1;
             while(j<k){
                 if(arr[i]+arr[j]==arr[k]){
                     return true;
                 }else if(arr[i]+arr[j] < arr[k]){
                     k--;
                     while(arr[k] ==arr[k+1]){
                         k--;
                     }

                 }else{
                     j++;
                     while(arr[j] ==arr[j-1]){
                         j++;
                     }
                 }
                 
                 
             }
        }
        return false;
    }

    public static void main(String[] args) {
         System.out.println(pythagoreanTriplet(3 ,2, 4, 6, 5));
    }
}