package org.example.TwoPointerSlidingWindow;

import java.util.Arrays;

public class Transpose {
    public  static  void rotate(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
       // Arrays.stream(mat).forEach(e-> System.out.print(Arrays.toString(e)));
           for(int i=0;i<n;i++) {
               int j=n-1;

           }
    }
        public static void main(String[] args) {
         int a[][]={{1,2,3},{4,5,6},{7,8,9}};
         rotate(a);

    }
}
