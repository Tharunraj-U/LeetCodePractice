package org.example.Graph;

class FloydWarshall {
    public void floydWarshall(int[][] dist) {
       int n=dist.length;
       
       for(int k=0;k<n;k++){
           for(int i=0;i<n;i++){
               for(int j=0;j<n;j++){
                 if(dist[i][k] != 100000000 && dist[k][j] !=100000000){
                       dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                 }
               }
           }
       }
       for(int i=0;i<n;i++){
           if(dist[i][i]<0){
               System.out.print("It as negative values");
           }
       }
       
        
    }
}