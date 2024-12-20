package org.example.DailyProblems;

import java.util.Arrays;

public class MissingEle {
    public  static char find(String s){
        int i=0,j=s.length()-1;
        while (i<j){
            if(s.charAt(i) != s.charAt(j)){
                if(isAnagram(i+1,j,s)){
                    return s.charAt(i);
                }
                if(isAnagram(i,j-1,s)){
                    return s.charAt(j);
                }

            }
            i++;
            j--;
        }
        return ' ';

    }

    private static boolean isAnagram(int i, int j,String s) {
        while (i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s="aaamaa";
        char a=find(s);
        System.out.print(a);
    }
}
