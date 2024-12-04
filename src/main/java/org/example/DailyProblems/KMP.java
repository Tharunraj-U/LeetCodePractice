package org.example.DailyProblems;

import java.util.Arrays;
import java.util.HashMap;

public class KMP {
    public  static boolean copmare(int arr[],String txt,String ptn){
        int j=0;
        for(int i=0;i<txt.length();i++){
            char c=txt.charAt(i);
            if(c == ptn.charAt(j)){
                j++;
            }
            else{
               j=arr[j+1];
            }
        }
        if(j == arr.length -1)return  true;
        return  false;
    }



    public static void main(String[] args) {
        String s="ababd";
        String s1="ababcabcabababd";
        //s.contains()//
        int arr[]=new int[s.length()+1];
        int i=1;
        for(int j=0;j<s.length();j++){

           int index=s.indexOf(s.charAt(j));
           arr[i++]= index == -1 || index == j ? 0 : index+1;

        }
       System.out.print(copmare(arr,s1,s));
        System.out.print(Arrays.toString(arr));
    }
}
