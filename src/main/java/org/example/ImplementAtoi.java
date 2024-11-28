package org.example;

public class ImplementAtoi {
    class Solution {
        public int myAtoi(String s) {
            long ans=0;
            boolean neg=false;
            s=s.trim();
            if(s.charAt(0) == '-'){
                neg=true;
            }
            for(char a:s.toCharArray()){
                if(a == '-'){
                    continue;
                }
                if( a+0 > 57  ){
                    break;
                }
                else{
                    ans=ans*10+(a-48);
                }
            }
            if(neg)ans*=-1;
            if(ans > Integer.MAX_VALUE)return Integer.MAX_VALUE;
            if(ans < Integer.MIN_VALUE)return Integer.MIN_VALUE;
            return  (int)ans;
        }
    }
}
