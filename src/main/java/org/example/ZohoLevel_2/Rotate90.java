package org.example.ZohoLevel_2;

class Rotate90 {
    static void rotate(int mat[][]) {
      for(int i=0;i<mat.length-1;i++){
          for(int j=i+1;j<mat[0].length;j++){
              int temp=mat[i][j];
              mat[i][j]=mat[j][i];
              mat[j][i]=temp;
          }

      }
      for(int arr[]:mat){
          rev(arr);
      }
        
    }
    public static void rev(int arr[]){
        int i=0,j=arr.length-1;
        while(i<j)arr[i]=arr[j]^arr[i]^(arr[j--]=arr[i++]);
    }
}