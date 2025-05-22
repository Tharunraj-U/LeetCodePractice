package org.example.DailyProblems;

import java.util.Arrays;

class LengthAfterTransformations {
    public  static  int lengthAfterTransformations(String s, int t) {
       int arr[]=new int[26];
     
       for(int c:s.toCharArray()){
            arr[c-'a']++;
       }
       while(t>0){
         //   System.out.println(Arrays.toString(arr));
           int val=arr[25];
           for(int i=24;i>=0;i--){
               arr[i+1]=arr[i];
            }
            arr[0]+=val;
            arr[1]+=val;
           // System.out.println(Arrays.toString(arr));
            t--;
       }
       int ans=0;
       
       for(int i=0;i<26;i++){
         ans+=arr[i];
       }
       return ans;
    }

    public static void main(String[] args) {
        lengthAfterTransformations("abcyy",2);
    }
}