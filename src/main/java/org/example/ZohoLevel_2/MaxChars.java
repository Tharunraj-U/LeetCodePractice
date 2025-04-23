package org.example.ZohoLevel_2;

import java.util.*;

class MaxChars
{
    public int maxChars(String s)
    {  int ans=0;
        Map<Character,Integer> map=new HashMap<>();
       for(int i=0;i<s.length();i++){
         map.put(s.charAt(i),i);  
       }
       int max=-1;
        for(int i=0;i<s.length();i++){
            if(!(map.get(s.charAt(i)) == i)){
                 max=Math.max(max,map.get(s.charAt(i))-i-1);
            }
        }
       
       return max;
    }
}