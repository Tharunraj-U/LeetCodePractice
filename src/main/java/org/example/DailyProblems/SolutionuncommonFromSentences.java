package org.example.DailyProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class SolutionuncommonFromSentences {
    public static String[] uncommonFromSentences(String s1, String s2) {
        s1=s1.trim();
        s2=s2.trim();
        Map<String,Integer> obj=new HashMap<>();
        
        int j=0;
        for(int i=0 ;i<s1.length();i++){
            if(i == s1.length()-1){
                if(obj.containsKey(s1.substring(j))){
                    obj.remove(s1.substring(j));
                    System.out.println( "removed"+s1.substring(j) + " ");
                }
                else{
                    obj.put(s1.substring(j,i+1),j);
                    System.out.println( "added"+s1.substring(j) + " ");
                }

            }

             else if(s1.charAt(i) == ' ' ){
            if(obj.containsKey(s1.substring(j,i+1))){
               obj.remove(s1.substring(j,i+1)); 
                System.out.println( "removed"+s1.substring(j,i+1) + " ");
            }
            else{
                obj.put(s1.substring(j,i+1),j);
                 System.out.println( "added"+s2.substring(j,i+1) + " ");
            }
            j=i+1;
            }
        }
        for (Map.Entry<String, Integer> entry : obj.entrySet()) {
            System.out.print(entry.getKey() +" ");
        }
         j=0;
        for(int i=0 ;i<s2.length();i++){
            if(i == s2.length()-1){
                if(obj.containsKey(s2.substring(j))){
                    obj.remove(s2.substring(j));
                    System.out.println( "removed"+s2.substring(j) + " ");
                }
                else{
                    obj.put(s2.substring(j,i+1),j);
                    System.out.println( "added"+s2.substring(j) + " ");
                }

            }
            else if(s2.charAt(i) == ' '){
            if(obj.containsKey(s2.substring(j,i+1))){
               obj.remove(s2.substring(j,i+1)); 
                System.out.println( "removed"+s2.substring(j,i+1) + " ");
            }
            else{
                obj.put(s2.substring(j,i+1),j);
                System.out.println( "added"+s2.substring(j,i+1) + " ");
            }
            j=i+1;
            }
        }
        for (Map.Entry<String, Integer> entry : obj.entrySet()) {
            System.out.print(entry.getKey() +" ");
        }

        Set<String> keys = obj.keySet();

        return  keys.toArray(new String[0]);
        
    }

    public static void main(String[] args) {
        System.out.println(uncommonFromSentences("this apple is sweet","this apple is sour").toString());
    }
}