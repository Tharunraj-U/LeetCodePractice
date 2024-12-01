package org.example.DailyProblems;

public class CheckNandItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            int val=arr[i];
            if(bin(val*2,i,arr)){
                return true;
            }
        }
        return false;
    }
    public boolean bin(int val,int s,int []arr){
        int l=0;
        int r=arr.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==val && mid != s){
                return true;
            }
            else if( arr [mid] > val){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return false;
    }
}
