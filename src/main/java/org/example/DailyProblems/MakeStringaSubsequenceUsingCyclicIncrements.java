package org.example.DailyProblems;

public class MakeStringaSubsequenceUsingCyclicIncrements {
    class Solution {
        public boolean canMakeSubsequence(String str1, String str2) {
            if(str1.length() < str2.length())return false;
            int i=0,j=0;
            while( i<str1.length() && j<str2.length()){
                int char1=(str1.charAt(i)),char2=(str2.charAt(j));
                if(char1 == char2 || char1+1 == char2 || (char1==122 && char2==97))j++;
                i++;
            }
            return j == str2.length();
        }
    }
}
