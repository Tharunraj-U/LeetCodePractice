package org.example.Graph;

import java.util.*;

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
         Queue<int[]> queue=new LinkedList<>();
         queue.offer(new int[]{sr,sc});
         int col= image[sr][sc];
         boolean vis[][]=new boolean[image.length][image[0].length];
         while(!queue.isEmpty()){
            int node[]=queue.poll();
             vis[node[0]][node[1]]=true;
             image[node[0]][node[1]]=newColor;
           for(int arr[]:dir){
               int i=arr[0]+node[0];
               int j=arr[1]+node[1];
               if(i> -1 && j > -1 && i < image.length && j < image[0].length && image[i][j] == col && !vis[i][j]){
                   queue.offer(new int[]{i,j});
               }
           }   
         }
         return image;
         
        
    }
}