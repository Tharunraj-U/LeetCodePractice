package org.example.DailyProblems;

public class AddBinaryStrings {

        public String addBinary(String s1, String s2) {
            int val1=0,val2=0;
            int n=s1.length()-1, n1=s2.length()-1;
            for(int i=n;i > -1;i--){
                int bin=s1.charAt(i)-48;
                int pov=n-i;
               val1+=(int)Math.pow(bin == 1 ? 2 : 0,pov);
            }
            for(int i=n1;i > -1;i--){
                int bin=s2.charAt(i)-48;
                int pov=n1-i;
                val2+=(int)Math.pow(bin == 1 ? 2 : 0,pov);
            }

            String binaray="";
             while (val1 > 0){
                 int rem=val1 %2;
                 val1=val1 /2;
                 binaray=rem+binaray;
             }

            return binaray;
        }

    public static void main(String[] args) {
        System.out.println( new AddBinaryStrings().addBinary("1011011","11"));
    }
}
