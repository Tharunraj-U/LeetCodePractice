package org.example.DailyProblems;

import java.util.ArrayList;
import java.util.List;

class SolutionsumPrefixScores {
    public  static int[] sumPrefixScores(String ... words) {
        int [] ans=new int[words.length];
        int i=0;
        for(String s: words){
         int score=getScore(words,s);
         ans[i++]=score;
        }
        return ans;
    }
    public static int getScore(String[] w,String s){
        int ans=0;
        List<String> obj=new ArrayList<String>();
        for(int i=1;i<=s.length();i++){
            obj.add(s.substring(0,i));
        }
        for(String a:obj){
            ans+=getEachScore(a,w);
            // System.out.println(a);
        }
        // System.out.print(obj.toString());
        // System.out.println();
        return ans;
    }
    public static int getEachScore(String s,String[] w){
        int ans=0;
        for(String s1:w ){
            int min=s.length();
            if( s1.length() >= min){
                System.out.println(s1.substring(0,min) +" "+s.substring(0,min));
                if(s1.substring(0,min).equals(s.substring(0,min))){

                    ans++;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
       int arr[]= sumPrefixScores("abc","ab","bc","b");
        System.out.println("_____________________");
       for( int a: arr){
           System.out.println(a);
       }
    }
}