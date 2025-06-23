package org.example.Pattern;

public class Basic {
   public  static void square(int n){
       for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
       }
   }
   public  static void pattern1(int n){

       for(int i=1;i<=n;i++){
           int val= i % 2 != 0 ? 0 :1;
           for(int j=1;j<=i;j++){
                val= val == 0 ? 1 :0;
               System.out.print(val);
           }
           System.out.println();
       }
   }
   public static  void patternG(int n){
       for(int i=1;i<=n;i++){
           for(int j=1;j<=n-i+1;j++){
              System.out.print("*");
           }
           System.out.println();
       }

   }
    public static  void patternJ(int n){

        for(int i=1;i<n*2;i++){
            if(i > n){
                for(int j=1;j<=(n*2)-i;j++){
                    System.out.print("*");
                }
            }else{
                for (int j=1;j<=i;j++){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    public  static void patternK(int n){
       for(int i=1;i<=n;i++){
           for(int j=1;j<=n-i;j++){
               System.out.print("_");
           }
            for(int j=1;j<=i;j++){

                System.out.print("*");
            }
            System.out.println();
       }
    }
    public  static void patternK1(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                System.out.print("_");
            }
            for(int j=1;j<=n-i+1;j++){

                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void  prammid(int n){
       for(int i=1;i<=n;i++){
           for(int j=1;j<=n-i;j++){
               System.out.print("_");
           }
           for(int j=1;j<(i*2);j++){
              if(j == 1 || j == (i*2)-1 || i == n){
                  System.out.print("*");
              }else{
                  System.out.print("_");
              }
           }
           System.out.println();
       }
    }
    public static void main(String[] args) {
       // square(5);
      //  pattern1(5);
       // patternG(5);
       // patternJ(5);
        // patternK1(5);
        prammid(5);
    }
}
