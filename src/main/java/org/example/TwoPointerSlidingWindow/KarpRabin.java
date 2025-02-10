package org.example.TwoPointerSlidingWindow;

public class KarpRabin {
    public  double  hashFunction(String s){
         double hash=0;
         for(int i=0;i<s.length();i++){
             hash+=s.charAt(i)*Math.pow(101,i);
         }
        return hash;
    }
    public double windowHash(char oldChar,char newChar,double prevHas,int i){
        double newHash=(prevHas - oldChar)/101;
        return newHash+newChar*Math.pow(101,i-1);
    }
    public void Search(String s,String s1){

        double hash=hashFunction(s);
        double hash2=hashFunction(s1.substring(0,s.length()));
        for(int i=0;i<=s1.length()-s.length();i++){
            if(hash==hash2){
                 System.out.println(s1.substring(i,i+s.length()));
            }
            if(i < s1.length()-s.length()){
                hash2=windowHash(s1.charAt(i),s1.charAt(i+s.length()),hash2,s.length());
            }
        }
    }
    public static void main(String[] args) {
        new KarpRabin().Search("tharunraj","tharunrajMy name is tharunraj");
    }
}
