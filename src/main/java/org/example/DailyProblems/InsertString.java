package org.example.DailyProblems;

public class InsertString {
    class Solution {
        public String addSpaces(String s, int[] spaces) {
            StringBuilder s2=new StringBuilder();
            int j=0;
            StringBuilder s1=new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(  j < spaces.length && i == spaces[j]){
                    j++;
                    s2.append(" "+s1);
                    s1.setLength(0);
                    s1.append(s.charAt(i));
                }else{
                    s1.append(s.charAt(i));
                }
            }
            s2.append(" "+s1);

            while(  0 < s2.length() && Character.isWhitespace(s2.charAt(0))){
                s2.deleteCharAt(0);
                break;

            }

            return s2.toString();
        }

    }

}
