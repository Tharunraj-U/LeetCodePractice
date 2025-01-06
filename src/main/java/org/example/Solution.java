package org.example;

class Solution {
    public int[] minOperations(String boxes) {
        int ans[]=new int[boxes.length()];
        int sum=0,b=0;
        for(int i=0;i<boxes.length();i++){
            char ch=boxes.charAt(i);
            if(ch == '1' ){
                sum+=i;
                 b++;
            }
            
        }
       
        int left=0;
        int l=boxes.charAt(0) == '1' ? 1:0;
         ans[0]=sum;
         for(int i=0;i<boxes.length();i++){
             ans[i]=left+sum;
            char ch=boxes.charAt(i);
            if(ch == '1'){
                left++;
                b--;
            } 
            sum-=b;
            left+=l;
           
           
        }
       
        return ans;
    }
}