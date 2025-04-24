package org.example.ZohoLevel_2;
import  java.util.*;
class WordBreak
{
    
    public static int wordBreak(String A, ArrayList<String> B )
    {
       Set<String> set=new HashSet<>();
       for(String a:B){
           set.add(a);
       }
       
       return hel(A,set) ? 1 : 0;
    }
    public static  boolean hel(String s,Set<String> set){
        if(set.contains(s) || s.length() == 0){
            return true;
        }
     
        for(int i=1;i<=s.length();i++){
            String s1=s.substring(0,i);
            if(set.contains(s1)){
                if(hel(s.substring(i),set)){
                    return true;
                }
            }
            
        }
        return false;
    }
}