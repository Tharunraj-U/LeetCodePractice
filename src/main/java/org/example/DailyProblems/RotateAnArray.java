package org.example.DailyProblems;

import java.util.Arrays;
public class RotateAnArray {
    private static void roatate(int[] a, int n) {
        n=n%n;
        for(int i=0;i<n;i++){
            int val=0;
            for(int j=1;j<a.length;j++){
                int temp=a[val];
                a[val]=a[j];
                a[j]=temp;
                val=j;
            }
        }
    }
    public static void main(String[] args) {
        int a[]={7, 3, 9, 1};
        roatate(a,9);
        System.out.print(Arrays.toString(a));
    }


}
