package org.example.DailyProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ZSolution {
    public void set(int mat[][],int i,int j){
        int r=i-1,c=j;
        while(r >-1 ){
            mat[r--][c]=0;
        }
         r=i+1;c=j;
        while(r<mat.length ){
            mat[r++][c]=0;
        }
         r=i;c=j+1;
        while( c<mat[0].length){
            mat[r][c++]=0;
        }
         r=i;c=j-1;
        while( c>-1){
            mat[r][c--]=0;
        }
        
    }
    public void setMatrixZeroes(int[][] mat) {
        List<List<Integer>> list1=new ArrayList<>();
        int i=0;
        for(int a[] : mat){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<a.length;j++){
               if(a[j]==0){
                   list.add(i);
                   list.add(j);
               }
            }
            if(list.size() !=0) list1.add(list);
            i++;
        }
        System.out.print(list1);
        for(List<Integer> l:list1){
             i=l.get(0);int 
             j=l.get(1);
            set(mat,i,j);
        }
        
    }

    public static void main(String[] args) {
        int mat[][]={{1, -1, 1},
                {-1, 0, 1},
        {1, -1, 1}};
        new ZSolution().setMatrixZeroes(mat);
        Arrays.stream(mat).forEach(a->System.out.println(Arrays.toString(a)));
    }
}