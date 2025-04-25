package org.example.ZohoLevel_2;

class IntegerToEnglishWords {
     String O_N[]={
         "",
         "One", "Two","Three", "Four", "Five","Six","Seven","Eight",
         "Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen",
         "Sixteen", "Seventeen","Eighteen","Nineteen"
     }; 
     String T_N[]={
        "","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy",
        "Eighty","Ninety"
     };
     String others[]={"","Thousand","Million","Billion","Trillen"};
     public String getString(int n){
       
        StringBuilder ans=new StringBuilder();
        int h= n/100;
        if(h > 0){
            ans.append(O_N[h]+" "+"Hundred ");
        }
        int Two=n%100;
        if(Two >=20){
            int T=Two/10;
            ans.append(T_N[T]+" ");
            int one=Two % 10;
            if(one > 0){
                ans.append(O_N[one]);
            }
        }else if(Two > 0){
            ans.append(O_N[Two]);
        }
        return ans.toString().trim();
     }
    public String numberToWords(int num) {
         if(num == 0)return "Zero";
    StringBuilder sb=new StringBuilder();
    int i=0;
    while(num>0){
        int curr=num %1000;
        if(curr !=0 ){
            sb.insert(0,getString(curr)+" "+others[i]+" ");
        }
        i++;
        num/=1000;
    }
    return sb.toString().trim();
    }
}