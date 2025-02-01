package org.example.DailyProblems;

public class Geeks {
    public static boolean dfs(char [][] mat,String word,int i,int j,int index,boolean vis[][]){
        vis[i][j]=true;
        if(index == word.length()-1)return true;
        int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
        for(int arr[]:dir){
            int newi=i+arr[0];
            int newj=j+arr[1];
            if(newi > -1 && newj > -1 && newi < mat.length && newj < mat[0].length && !vis[newi][newj] && mat[newi][newj]== word.charAt(index+1)){
                if(index+1 == word.length()-1)return true;
                return dfs(mat,word,newi,newj,index+1,vis);

            }
        }
        return false;
    }
    static public boolean isWordExist(char[][] mat, String word) {

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==word.charAt(0)){
                    boolean vis[][]=new boolean[mat.length][mat[0].length];
                    if(dfs(mat,word,i,j,0,vis)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
