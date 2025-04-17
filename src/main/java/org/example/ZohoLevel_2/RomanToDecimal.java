package org.example.ZohoLevel_2;

import java.util.HashMap;

class RomanToDecimal{
   
    public static void romanToDecimal(String s) {
        int []val={1000,500,100,50,10,5,1};
        char sy[]={'M','D','C','L','X','V','I'};
        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0;i<sy.length;i++)map.put(sy[i],i);
       int ans=0;
       for(int i=0;i<s.length();i++){
           int i1=map.get(s.charAt(i));
         if(i+1 < s.length()){
         int i2=map.get(s.charAt(i+1));
          if( i1 > i2 )ans-=val[i1];         
          else ans+=val[i1];
          continue;
         }
         ans+=val[i1]; 
          
      }
     System.out.println(ans);
    }

    public static void main(String[] args) {
         romanToDecimal("V");
    }
}