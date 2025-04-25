package org.example.ZohoLevel_2;

public class SumOfTwoLargeNumbers {
    String stringToNumber(String s1,String s2){
        int i1=s1.length()-1,i2=s2.length()-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while(i1 > -1 && i2 > -1){
            int n1=s1.charAt(i1)-'0';
            int n2=s2.charAt(i2)-'0';
            int val=carry+n1+n2;
            carry=val/10;
            val%=10;
            //  System.out.println(n1);
            sb.insert(0,val+"");
            i1--;
            i2--;
        }
        while(i1 > -1 ){
            int n1=s1.charAt(i1)-'0';
            int val=carry+n1;
            carry=val/10;
            val%=10;
            sb.insert(0,val+"");
            i1--;
        }
        while(i2 > -1){
            int n2=s2.charAt(i2)-'0';
            int val=carry+n2;
            carry=val/10;
            val%=10;
            sb.insert(0,val+"");
            i2--;
        }
        if(carry>0){
            sb.insert(0,carry+"");
        }
        return sb.toString().isEmpty() ? "0" :sb.toString();
    }
    String findSum(String s1, String s2) {
        s1=s1.replaceFirst("^0+","");
        s2=s2.replaceFirst("^0+","");
        return stringToNumber(s1,s2);
    }
}
