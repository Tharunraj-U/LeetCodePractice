package org.example.searching;

public class Binary {
    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6,7,8,9,10};
        int i=0,j=a.length-1,k=9;
        while (i<j){
            int mid=(i+j)/2;
            if(a[mid] == k){
                System.out.print(mid);
                return;
            }else if( a[mid] <=k){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
    }
}
