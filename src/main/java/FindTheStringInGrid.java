class FindTheStringInGrid
 {
    public static boolean dfs(char arr[][],int i,int j,String ans){
        int rows=arr.length;
        int cols=arr[0].length;
                  // up     down  right  left   1`o    4'o  11'o  7'o
        int dir[][]={{-1,0},{1,0},{0,1},{0,-1},{-1,1},{1,1},{-1,-1},{1,-1}};
        for(int i1=0;i1<8;i1++){
            int newr=i;
            int newc=j;
            int currLen=0;
            int count=0;
            while(newr > -1 && newc > -1 && newr < rows && newc < cols){
               if(count >= ans.length())break;
               if(arr[newr][newc] == ans.charAt(currLen))currLen++;
               count++;
               if(currLen == ans.length() && count == currLen)return true;
                newr+=dir[i1][0];
                newc+=dir[i1][1];
            }
        }
        return false;
    }
  
    public int[][] searchWord(char[][] grid, String word) {
       
     List<int[]> list=new ArrayList<>();
     for(int i=0;i<grid.length;i++){
         for(int j=0;j<grid[0].length;j++){
              if(grid[i][j] == word.charAt(0)){
                  if(dfs(grid,i,j,word))list.add(new int[]{i,j});
              }
         }
         
     }
     int arr[][]=new int[list.size()][2];
         for(int i=0;i<list.size();i++){
             arr[i]=list.get(i);
         }
         return arr;
    }
}