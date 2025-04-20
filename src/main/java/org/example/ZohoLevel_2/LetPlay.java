package org.example.ZohoLevel_2;

import java.util.Arrays;

class LetPlay{
    static int isSuperSimilar(int n, int m, int mat[][], int x)
    {   int mat1[][]=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++)mat1[i]= Arrays.copyOf(mat[i],mat[0].length);
        for(int i=0;i<x;i++){
            int c=0;
            for(int arr[]:mat){
                if(c%2 == 0){
                    rightRoatate(arr);
                }else{
                    leftRoatate(arr);
                }
                c++;
            }
        }
       
               
        return Arrays.deepEquals(mat,mat1) ? 1 : 0;
    }
    public static void rightRoatate(int mat[]){
        int n=mat.length;
        int last=mat[n-1];
         for (int i = n - 1; i > 0; i--) {
            mat[i]=mat[i-1];
        }
        mat[0]=last;
    }
  
    public static void leftRoatate(int mat[]){
        int n=mat.length;
        int last=mat[0];
        for(int i=0;i<n-1;i++){
            mat[i]=mat[i+1];
        }
        mat[n-1]=last;
    }
}