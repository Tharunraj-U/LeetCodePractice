package org.example.sorting;

import java.util.Arrays;

public class MergeSort {


    public static int[] merge(int []l,int r[]){
        System.out.print(Arrays.toString(l));
        System.out.print(Arrays.toString(r));
        int ans[]=new int[l.length+r.length-1];
        System.arraycopy(l,0,ans,0,l.length);
        System.arraycopy(r,0,ans,l.length,r.length);

        return ans;
    }
    public static  int[] split(int s,int e,int[] arr){
        int []left=Arrays.copyOfRange(arr,s,e+1),right=Arrays.copyOfRange(arr,s,e+1);
        if( s < e){
            int mid=s+(e-s)/2;
           left=split(s, mid, arr);
            right=split(mid + 1, e, arr);

        }
        arr= merge(left,right);
        return arr;



    }
    public static void main(String[] args) {
        int a[]={1,2,3,4};
        split(0,a.length-1,a);
    }
}
