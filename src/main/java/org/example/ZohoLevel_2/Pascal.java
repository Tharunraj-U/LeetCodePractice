package org.example.ZohoLevel_2;

public class Pascal {
     static long  fact(int r,int c){
           long res=1;
           for(int i=1;i<=c;i++){
                 res=res*r/i;
                 r--;
           }
           return res;
     }
    public static void main(String[] args) {
        int n=1000000000;
        for(int r=1;r<=n;r++){
            for(int c=0;c<r;c++){
                System.out.print(fact(r-1,c)+" ");
            }
            System.out.println();
        }
    }
}
