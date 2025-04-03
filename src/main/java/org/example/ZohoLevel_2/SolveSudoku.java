package org.example.ZohoLevel_2;

class SolveSudoku {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
               if(board[i][j]=='.'){
                  for(int t=1;t<10;t++){
                    if(posible(board,i,j,(char)(t+'0'))){
                        board[i][j]=(char)(t+'0');
                        if(solve(board)){
                            return true;
                        }
                         board[i][j]='.';
                    }
                  }
                  return false;  
               }
            }
        }
        return true;
    }
    public boolean posible(char mat[][],int row,int col,char val){
        for(int i=0;i<9;i++){
            if(mat[row][i]==val)return false;
            if(mat[i][col]==val)return false;
            if(mat[3*(row/3)+i/3][3*(col/3)+i%3] == val)return false;   
        }
        return true;
    }

    public static void main(String[] args) {

    }
}