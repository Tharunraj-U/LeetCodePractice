package org.example.ZohoLevel_2;

import java.util.*;

class SameFreq {
    boolean sameFreq(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Set<Integer> set=new HashSet<>();
        for(int val:map.values()){
            set.add(val);
        }
        if(set.size() <=1)return true;
        if(set.size() > 2)return false;
         Iterator<Integer> list=set.iterator();
         int val1=list.next(),val2=list.next();
         if(val1 == 1 && val2 ==1)return true;
         int max=Math.max(val2,val2);
          int min=Math.min(val1,val2);
         int maxCount=0,minCount=0;
         for(int val:map.values()){
             if(max == val){
                 maxCount++;
             }else  minCount++;
         }
            //bbbcccaa                             //aabbcz 
         if((maxCount > minCount && min >1) || (maxCount > 1 && minCount > 1)){
             return false;
         }
         
         return Math.abs(val1-val2) ==1;
        
    }
}