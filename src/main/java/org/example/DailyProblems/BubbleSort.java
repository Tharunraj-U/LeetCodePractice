package org.example.DailyProblems;

import java.util.Arrays;

;

public class BubbleSort {


    public static  int[] BubbleSort(int...arr){

        for(int i=0;i< arr.length;i++){
            int p1=0,p2=1;
            while ( p2 < arr.length-i ){
                if(arr[p1]>arr[p2]){
                    int temp=arr[p1];
                    arr[p1]=arr[p2];
                    arr[p2]=temp;
                }
                p2++;
                p1++;
            }
        }
        return  arr;
    }
    public static int[] CyclicSort(int...arr){
        int i=0;
        while(i < arr.length){
            if( arr[i] <arr.length && arr[i] != i){
                swap(arr,i,arr[i]);
            }else{
                i++;
            }

        }
        return arr;
    }
    public static int[] CyclicSort2(int...arr){
        int i=0;
        while(i < arr.length){
            int curr=arr[i]-1;
            if( curr >0 && curr <arr.length && curr  != i){
                swap(arr,i,curr);
            }else{
                i++;
            }

        }
        return arr;
    }

    private static void swap(int[] arr, int i,int val) {
        int temp=arr[i];
        arr[i]=arr[val];
        arr[val]=temp;
    }


public static int[] merge(int[] left,int[] right){
    int i=left.length,j=right.length;
    int[] temp=new int[i+j];

     int i1=0,j1=0;
     int ptr=0;
     while(i1<i && j1<j){
         if(left[i1] <= right[j1]){
             temp[ptr++]=left[i1++];
         }
         else if (left[i1] >= right[j1]){
             temp[ptr++]=right[j1++];
         }

     }
     while( i1 <i){
         temp[ptr++]=left[i1++];
     }
    while( j1 <j){
        temp[ptr++]=right[j1++];
    }

    return temp;
    }
    public  static int[] Divide(int l,int r,int...arr){
        if (l == r) {
            System.out.print(arr[l]+"->");
            return new int[] { arr[l] };  // Return the single element
        }
        int mid=(l+r)/2;



          
            int []left=Divide(l,mid,arr);
//
           int [] right=Divide(mid+1, r,arr);
//
            


        return merge(left,right);
    }


    public static void QuickSort(int l,int r,int[] arr){
        if( l <r){
            int pivot=helper2(l,r,arr);
            QuickSort(l,pivot-1,arr);
            QuickSort(pivot+1,r,arr);
        }



    }

    private static int helper(int start, int end, int[] arr) {
        int  pivot=arr[end];
        int j=start-1;
        for(int i=start;i<end;i++){
            if(pivot > arr[i]){
                j++;
                swap(arr,i,j);
            }

        }
        j++;
        swap(arr,end,j);
        return j;
    }
    private static int helper2(int start, int end, int[] arr) {
        int  pivot=arr[start];
        int j=end+1;
        int i=end;
        while(i != start){
            if(arr[i] > pivot){
                j--;
                swap(arr,j,i);
            }
            i--;
        }
        j--;

        swap(arr,start,j);
        return j;
    }

    public static void main(String[] args) {
//        System.out.print(Arrays.toString(BubbleSort(1,23,2,3,23,2324,4,0)));
//        System.out.print(Arrays.toString(CyclicSort(1,7,43,5,54,45,6,0,2,4,3)));
//        System.out.print(Arrays.toString(CyclicSort2(2,3,1,4)));
//        System.out.print(Arrays.toString(CyclicSort2(1,7,43,5,54,45,6,0,2,4,3)));
//        System.out.print(Arrays.toString(Divide(0, arr.length-1,arr)));
        int arr[]={2,1,1,7,43,5,54,45,6,0,2,4,34,3};
        QuickSort(0, arr.length-1,arr);
        System.out.print(Arrays.toString(arr));

    }
}
