package org.example.ZohoLevel_2;

class CelebrityProblem {
    public int celebrity(int mat[][]) {
        if(mat.length == 1 && mat[0].length ==1)return 0;
        int i=0,j=mat.length-1;
        while(i<j){
             if(mat[i][j] ==1 && mat[j][i] ==1){
                 i++;
                 j--;
             }else if(mat[i][j] ==1){
                 i++;
             }else if(mat[j][i] == 1){
                 j--;
             }
             if(i ==j && isCel(i,mat)){
                return i;
            }
            else if(mat[i][j] ==0 && mat[j][i] ==0){
                 if(isCel(1,mat))j--;
                 else i++;
             }
             
        }
        return   -1;
    }
    public boolean isCel(int i,int mat[][]){
         // row
        for(int j=0;j<mat.length;j++)if( (i != j && mat[i][j] == 1 )||  ( i == j && mat[i][j] ==0)) return false;
      
        // col
        for(int j=0;j<mat.length;j++)if(mat[j][i] == 0 ) return false;
        
        return true;
    }
}