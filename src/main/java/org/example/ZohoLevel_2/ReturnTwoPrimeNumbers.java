package org.example.ZohoLevel_2;

class ReturnTwoPrimeNumbers{
    public static boolean isPrime(int n){
        if(n <= 1)return false;
        if(n == 2 || n == 3)return true;
        if(n % 2 == 0 || n % 3 == 0)return false;
        for(int i=5;i*i<=n;i+=6){
            if(n%i == 0 || n%(i+2) == 0)return false;
        }
        return true;
    }
    static List<Integer> primeDivision(int n) {
       List<Integer> list=new ArrayList<>();
       for(int i=2;i<=(n/2);i++){
           int n1=i;
           int n2=n-i;
           if(isPrime(n1) && isPrime(n2)){
               list.add(n1);
               list.add(n2);
               break;
           }
       }
       return list;
    }
}