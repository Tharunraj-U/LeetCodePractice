package org.example.ZohoLevel_2;

class WildcardMatching {
    public boolean isMatch(String p, String s) {
        Boolean  dp[][]=new Boolean [s.length()][p.length()];
        return hel(s,p,s.length()-1,p.length()-1,dp);
    }
    public static boolean hel(String s,String p,int i,int j,Boolean  dp[][]){
        if(i < 0 && j < 0)return true;
        if(i<0 && j >=0)return false;
        if(j<0 && i >=0){
            for(int ptr=0;ptr<=i;ptr++){
                if(s.charAt(ptr) !='*')return false;
            }
            return true;
        }
        if(dp[i][j] != null)return dp[i][j];
        if(s.charAt(i) == p.charAt(j) || s.charAt(i)=='?'){
            return dp[i][j]=hel(s,p,i-1,j-1,dp);
        }
        if(s.charAt(i) == '*'  ){
            return dp[i][j]=hel(s,p,i-1,j,dp) || hel(s,p,i,j-1,dp);
        }
        return dp[i][j]=false;
    }
}