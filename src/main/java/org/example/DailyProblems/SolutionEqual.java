package org.example.DailyProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionEqual {
    public boolean equal(int []a,int [] b){
        for(int i=0;i<26;i++){
            if(a[i] < b[i]){
                return false;
            }
        }
         return true;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list=new ArrayList<>();
       int count[]=new int[26];
       for(String s:words2){
         int count1[]=new int[26];
          for(char a:s.toCharArray()){
             int i=a-'a';
             count1[i]++;
             count[i]=Math.max( count1[i],count[i]);
          }
       }
        for(String s:words1){
          int count1[]=new int[26];
          for(char a:s.toCharArray()){
             int i=a-'a';
             count1[i]++;
          }
          if(equal(count1,count)){
            list.add(s);
          }
        }
       System.out.print(Arrays.toString(count));
       return list;
    }
}