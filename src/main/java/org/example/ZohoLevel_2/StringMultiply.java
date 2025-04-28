package org.example.ZohoLevel_2;

import java.util.Arrays;

class StringMultiply {
    public String multiply(String s1, String s2) {
        int res[]=new int[s1.length()+s2.length()];
        for(int i=s1.length()-1;i>-1;i--){
             int num1=s1.charAt(i)-'0';
            for(int j=s2.length()-1;j>-1;j--){
                int num2=s2.charAt(j)-'0';
                int ans=num1*num2+res[i+j+1];
                res[i+j+1]=ans%10;
                res[i+j]+=ans/10;
            }
           
        }
        System.out.println(Arrays.toString(res));
        int i=0;
        while( i<res.length && res[i] ==0){
            i++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i1=i;i1<res.length;i1++){
            sb.append(res[i1]);
        }
        return sb.length() == 0 ? "0" :sb.toString();
    }
}