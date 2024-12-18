package org.example.DailyProblems;

class FindPages {
    public static int findPages(int[] arr, int k) {
        if(arr.length < k)return -1;
       int s=Arrays.stream(arr).max().getAsInt(),e=Arrays.stream(arr).sum();
       while(s<=e){
           int mid=s+(e-s)/2;
           if(canPossible(arr,k,mid)){
               s=mid+1;
           }else{
               e=mid-1;
           }
       }
       return s;
    }
     public static boolean canPossible(int arr[],int noOf,int totalMin){
         int s=0,past=0;
         for(int a:arr){
             if(s+a <=totalMin) s+=a;
             else{
                 past++;
                 s=a;
             }
         }
         return noOf <= past;
     }
}