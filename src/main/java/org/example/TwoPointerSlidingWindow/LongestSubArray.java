package org.example.TwoPointerSlidingWindow;

public class LongestSubArray {
    public static void main(String[] args) {
        int a[]={1,1,2,3,3,4,4,1,1,1,0,1};
        int k=4;
        int max=0;
        int l=0;
        int sum=0;
        for(int i=0;i<a.length;i++){
           sum+=a[i];
            while(sum > k){
                sum-=a[l++];
            }
            max=Math.max(max,i-l+1);
        }
        System.out.print(max);
    }
}
