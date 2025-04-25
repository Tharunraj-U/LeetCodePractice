package org.example.ZohoLevel_2;

class NumberOfPaths {
   
    public int numberOfPaths(int m, int n) {
    Integer dp[][]=new Integer[m][n];
   return  hel(m-1,n-1,dp);
   
    }
    int  hel(int r,int c,Integer dp[][]){
        if(r == 0 && c == 0){
            return 1;
        }
        if(r < 0 || c < 0 )return 0;
        if(dp[r][c] != null)return dp[r][c];
        return dp[r][c]=hel(r-1,c,dp)+hel(r,c-1,dp);
        
    }
}