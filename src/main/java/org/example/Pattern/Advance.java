package org.example.Pattern;


public class Advance {
    public static void hollowGram(int n){
         for(int i=1;i<=(n*2);i++){
             if(i <=n){
                 for(int j=1;j<=n-i+1;j++){
                     System.out.print("* ");
                 }
                 for(int j=1;j<=(i-1)*2;j++){
                     System.out.print("_ ");
                 }
                 for(int j=1;j<=n-i+1;j++){
                     System.out.print("* ");
                 }
             }else{
                 for(int j=1;j<=((i%n) == 0 ? n :(i%n));j++){
                     System.out.print("* ");
                 }
                 for(int j=1;j<=(n*2)-((i%n)*2) && i != n*2;j++){
                     System.out.print("_ ");
                 }
                 for(int j=1;j<=((i%n) == 0 ? n :(i%n));j++){
                     System.out.print("* ");
                 }

             }
             System.out.println();
         }
    }
    public static void pattern2(int n){
        for(int i=1;i<n*2;i++){
           for(int j=1;j<n*2;j++){
               int min=Math.min(i,j);
               min=Math.min(min,n*2-i);
               min=Math.min(min,n*2-j);
               System.out.print(n-min+1+" ");
           }
           System.out.println();
        }
    }
    public static void main(String[] args) {
         // hollowGram(5);
        pattern2(5);
    }
}
