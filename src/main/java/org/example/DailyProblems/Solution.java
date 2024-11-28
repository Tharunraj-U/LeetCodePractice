package org.example.DailyProblems;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public  static  boolean isHappy(int n) {
        Set<Integer> obj =new HashSet<>();
        int sum=0;
        while( true){
            if(obj.contains(n)){
                System.out.print(n+" ");
                return false;
            }
            obj.add(n);
            sum=0;
            while(n >0){
                  int temp= n%10;
                   sum+=temp*temp;
                   n/=10;
                  
            }
            if(sum==1){
             return true;
            }
            n=sum;
            

        }
    }

    public static void main(String[] args) {
        isHappy(19);
    }
}