package org.example.DailyProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        System.out.println(map);
        int size=0,maxIndex=0,j=0;
         for(int i=0;i<s.length();i++){
            int curr=map.getOrDefault(s.charAt(i),0);
            if(curr > maxIndex){
                maxIndex=curr;
            }
            if(maxIndex >= curr){
                size++;
            }
             System.out.println(size+" "+(maxIndex-j)+" "+i);
            if(size > maxIndex-j){
                j=i+1;
//                System.out.println(j);
                list.add(size);
                size=0;
                maxIndex=0;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
    }
}