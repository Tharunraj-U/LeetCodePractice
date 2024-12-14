package org.example.DailyProblems;

public  class Bin {
  public  static int search(int[] arr, int key) {
        int r=last(arr,0,arr.length-1);
        if(r==-1){
            return bin(arr,0,arr.length-1,key);
        }else{
            int val1=bin(arr,0,r,key);
            int val2=bin(arr,r+1,arr.length-1,key);
            return val1 >= val2 ? val1 :val2;
        }

    }
    public static int last(int arr[],int s,int e){
        while(s<=e){
            int mid=s+(e-s)/2;
            if(mid+1 < arr.length && arr[mid] > arr[mid+1]){
                return mid;
            }
            return Math.max(last(arr,s,mid-1),last(arr,mid+1,e));
        }
        return -1;
    }
    public static int bin(int arr[],int s,int e,int k){
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]==k)return mid;
            else if(arr[mid] < k){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int arr[]={5, 6, 7, 8, 9, 10, 1, 2, 3};
        int last=search(arr,3);
        System.out.print(last);
    }
}
