package org.example.DailyProblems;

import java.util.*;

class PrintAnagramsSolution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
       Map<char[],ArrayList<String>> map=new HashMap<>();
       for(String s:arr){
           char[] a=s.toCharArray();
           Arrays.sort(a);
           if(map.containsKey(a)){
               map.get(a).add(s);
           }else{
               map.put(a,new ArrayList<>());
               map.get(a).add(s);
           }
       }
       ArrayList<ArrayList<String>> ans=new ArrayList<>();
       for(Map.Entry<char[],ArrayList<String>> obj:map.entrySet()){
           ArrayList<String> temp=obj.getValue();
           Collections.sort(temp);
           ans.add(obj.getValue());
       }
       return ans;
    }

    public static void main(String[] args) {

    }
}