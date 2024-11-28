package org.example.DailyProblems;

import java.util.Arrays;

public class PushZeros {
//    optimal solution
//    void pushZerosToEnd(int[] arr) {
//        int n=arr.length;
//        int zero=0;
//        for(int i=0;i<n;i++){
//            if(arr[i]==0){
//                continue;
//            }
//            if(zero != i){
//                arr[zero]=arr[i];
//                arr[i]=0;
//            }
//            zero++;
//
//        }
//    }
       static void pushZerosToEnd(int[] arr) {
            int n=arr.length;
            for(int i=0;i<n;i++){
                int temp=i;
                for(int j=i+1;j<n;j++){
                    if(arr[temp]==0 && arr[j] !=0){
                        arr[temp]=arr[j];
                        arr[j]=0;
                        temp=j;
                    }
                }
            }
        }
    public static void main(String[] args) {
       int a[]={3,5,0,0,4};
       pushZerosToEnd(a);
       System.out.print(Arrays.toString(a));
    }
}
