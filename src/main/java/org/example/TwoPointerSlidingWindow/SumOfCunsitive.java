package org.example.TwoPointerSlidingWindow;

public class SumOfCunsitive {
    public static void main(String[] args) {

        int a[]={1,2,3,4,5,5,6,7,89,};
        int j=0;
        int sum=0;
        int len=3;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            if((i-j) >= len-1){
                System.out.println(sum);
                sum-=a[j++];
            }

        }
    }
}
