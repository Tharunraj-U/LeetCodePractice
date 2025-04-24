package org.example.ZohoLevel_2;

import java.util.*;

class MakeADistinctDigitArray

{
    public int[] common_digits(int[] nums)
    {
       Set<Integer> set=new HashSet<>();
       for(int val:nums){
           hel(val,set);
       }
       int ans[]=new int[set.size()];
       int i=0;
      for(int val:set){
          ans[i++]=val;
      }
       return ans;
    }
    public void hel(int val,Set<Integer> set){
        while(val > 0){
            int temp=val%10;
            set.add(temp);
            val/=10;
        }
    }
}