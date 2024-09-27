//package org.example;
//
//import java.util.*;
//
//class SolutionAddBinary{
//    public static int[][] construct2DArray(int[] original, int m, int n) {
//        int ans[][]=new int[m][n];
//        int c=0;
//        List<Integer> helper=new ArrayList<>();
//        if(original.length < m+n  ){
//            return new int[][]{};
//        }
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                ans[i][j]=original[c];
//                c+=1;
//            }
//
//        }
//        int sum1=Arrays.stream(original).sum();
//        int sum = Arrays.stream(ans)
//                .flatMab pToInt(Arrays::stream)
//                .sum();
//        if(ans[m-1][n-1] != original[original.length-1] ||sum != sum1){
//            return new int[][]{};
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(construct2DArray(new int[]{3},1,2));
//    }
//}