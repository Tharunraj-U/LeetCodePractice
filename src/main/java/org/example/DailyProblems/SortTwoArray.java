package org.example.DailyProblems;

import java.util.Arrays;

public class SortTwoArray {
    public static void mergeArrays(int a[], int b[]) {
        int i=a.length-1,j=0;
        while( i > -1 && j < b.length){
            if(a[i] >= b[j] ){
                a[i]=a[i]^b[j]^(b[j]=a[i]);

            }
            j++;
            i--;
        }

        Arrays.sort(a);
        Arrays.sort(b);


    }

    public static void main(String[] args) {
//        int a[] = {2, 4, 7, 10}, b[] = {2, 3};
        int []a={1, 5, 9, 10, 15, 20};
        int b[] = {2, 3, 8, 13};
        mergeArrays(a,b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
