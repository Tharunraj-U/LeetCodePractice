package org.example.DailyProblems;

class CatchThieves {
    public static int catchThieves(char[] arr, int k) {
        int c=0,i=0;
        while(i<arr.length){
             if(arr[i] == 'P'){
                 int k1=k-1;
                 int j=i-1;
                 while(j > -1 && arr[j] != 'T' && k1 > 0){
                      j--;
                      k1--;
                 }
                 boolean f=true;
                 if(  j > -1 && arr[j] == 'T'){
                     c++;
                     arr[j]='H';
                     f=false;
                 }
                 if(f){
                 k1=k-1;
                 j=i+1;
                 while(j<arr.length && arr[j] != 'T' && k1 > 0){
                      j++;
                      k1--;
                 }
                   
                
                 if(j<arr.length && arr[j] == 'T'){
                     System.out.println(j);
                     c++;
                     arr[j]='H';
                   // i=j-1;
                 }
                 
                 }
                 
             }
             i++;
        }
        return c;
        
    }

    public static void main(String[] args) {
         System.out.println(catchThieves(new char[]{'T','P', 'P', 'P','P','P','T' ,'T'},2));
    }
}