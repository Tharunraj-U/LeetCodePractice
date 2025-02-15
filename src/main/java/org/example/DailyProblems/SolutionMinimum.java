package org.example.DailyProblems;

class SolutionMinimum {
    int min=Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        int r=matrix.length,c=matrix[0].length;
        for(int i=0;i<c;i++){
             helper(matrix,r-1,i,matrix[r-1][i]);
        }
        return min;

    }
    public void helper(int[][] matrix,int row,int col,int val){
        if(row < 0 ||col < 0)return;
        if(row == 0){
               min=Math.min(min,val);
        }
        if(row-1 > -1){
         helper(matrix,row-1,col,val+matrix[row-1][col]);
        }
        if( row-1 > -1 && col-1 > -1){
         helper(matrix,row-1,col-1,val+matrix[row-1][col-1]);
        }
        if(row-1 > -1 && col+1 < matrix[0].length){
         helper(matrix,row-1,col+1,val+matrix[row-1][col+1]);
        }
    }

    public static void main(String[] args) {
        int arr[][]={{2,1,3},{6,5,4},{7,8,9}};
       System.out.println( new SolutionMinimum().minFallingPathSum(arr));
    }
}