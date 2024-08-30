package org.example;

import java.util.*;

class Solution {
    public  int[] numberOfPairs(int[] nums) {


        Arrays.sort(nums);
        Map<Integer,Integer> ans=new HashMap<>();
         System.out.println(Arrays.toString(nums));
        int pair=0,i=0,size=0;
        while (i<nums.length){
            if(i+1 != nums.length  && nums[i]==nums[i+1]){
                ans.put(nums[i],nums[i+1]);
                i+=2;

                pair++;
            }
            else {
                i++;
                size++;
            }


System.out.println(ans);

        }
        System.out.println(ans);
     return new int []{pair,size} ;
    }

    public static void main(String[] args) {
        Solution obj=new Solution();
       int[] ans=obj.numberOfPairs(new int[]{1,1});
       for(int a:ans){
           System.out.println(a);
       }
    }
}