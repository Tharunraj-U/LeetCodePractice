package org.example;

public class ImplementAtoi {
    static class Solution {
        public int myAtoi(String s) {
            s=s.trim();
            if(s.isEmpty() || s== null){
                return 0;
            }
            long ans=0;
            boolean neg=false;
            int index=0,n=s.length();
            if(index < n && s.charAt(index) == '-' || s.charAt(index)== '+'){
                neg=s.charAt(index)=='-';
                index++;
            }
            char c;
            while(index < n && Character.isDigit(c=s.charAt(index))){
                ans=ans*10+(c-48);
                index++;
                if( neg && -ans < Integer.MIN_VALUE)return Integer.MIN_VALUE;
                if( !neg && ans > Integer.MAX_VALUE)return Integer.MAX_VALUE;
            }
            ans= neg ? -ans:ans;
            return (int)ans;
        }
    }

    public static void main(String[] args) {
      System.out.print(new Solution().myAtoi("  -042"));
    }
}
