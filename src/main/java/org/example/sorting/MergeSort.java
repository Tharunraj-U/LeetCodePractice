package org.example.sorting;

import java.util.Arrays;

public class MergeSort {


    public static void merge(int mid,int s,int e,int arr[]){
        int size1=mid-s+1;
        int size2=e-mid;
        int temp1[]=new int[size1];
        int temp2[]=new int[size2];
        for(int i=0;i<size1;i++){
            temp1[i]=arr[s+i];
        }
        for(int i=0;i<size2;i++){
            temp2[i]=arr[mid+i+1];
        }
        int i=0,j=0,ptr=s;
        while(i< size1 && j <size2){
            if(temp1[i] <=temp2[j]){
                arr[ptr++]=temp1[i++];
                continue;
            }arr[ptr++]=temp2[j++];
        }
        while( i<size1 || j<size2 ){
            if(i<size1){
                arr[ptr++]=temp1[i++];
                continue;
            }
            arr[ptr++]=temp2[j++];

        }



    }
    public static  void split(int s,int e,int[] arr){
        if( s < e){
             int mid=s+(e-s)/2;
             split(s, mid, arr);
             split(mid + 1, e, arr);
              merge(mid,s,e,arr);

        }




    }
    public static void main(String[] args) {
        int a[]={1,2,3,4,1,2,3,4};
         split(0, a.length - 1, a);
        System.out.print(Arrays.toString(a));
    }
}
