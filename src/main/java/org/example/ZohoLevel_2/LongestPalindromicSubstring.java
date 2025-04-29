package org.example.ZohoLevel_2;

class LongestPalindromicSubstring {
    
  
    public static String hel(String s1,int i,int j){
        while( i > -1 && j < s1.length() && s1.charAt(i) == s1.charAt(j)){
            i--;
            j++;
        }
        return s1.substring(i+1,j);
    }
    String longestPalindrome(String s) {
     if(s.length() ==1)return s;
      String ans="";
      for(int i=0;i<s.length()-1;i++){
          String ev=hel(s,i,i);
          String odd=hel(s,i,i+1);
          if(ev.length() > ans.length()){
              ans=ev;
          }
           if(odd.length() > ans.length()){
              ans=odd;
          }
      }
      return ans;
    }
}