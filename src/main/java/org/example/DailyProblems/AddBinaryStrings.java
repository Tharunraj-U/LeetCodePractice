package org.example.DailyProblems;

public class AddBinaryStrings {

    public String addBinary(String s1, String s2) {
        int n1=s1.length()-1;
        int n2=s2.length()-1;
        StringBuilder s=new StringBuilder();
        int c=0;
        while( n1 > -1 || n2 > -1 || c >0 ){
            int bin1= n1 >= 0 ? s1.charAt(n1)-48: 0;
            int bin2= n2 >= 0 ? s2.charAt(n2)-48: 0;
            int res=bin1+bin2+c;
            c=res/2;
            s.append(res%2);
            n1--;n2--;
        }
        s=s.reverse();
        while(s.charAt(0) == '0'){
            s.delete(0,1);
        }
        return s.toString();
    }


    public static void main(String[] args) {
        System.out.println( new AddBinaryStrings().addBinary("01","10"));
    }
}
