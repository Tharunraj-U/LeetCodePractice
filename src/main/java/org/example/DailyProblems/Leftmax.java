package org.example.DailyProblems;

import java.util.Arrays;
import java.util.Stack;

public class Leftmax {
    public static void main(String[] args) {
        int a[]={3, 5, 1, 0, 4, 0 ,2};
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[a.length];
        for(int i=a.length-1;i >=0;i--){
           int val=a[i];
           while (!stack.isEmpty() && val  >=stack.peek()) {
               stack.pop();
           }
          if(stack.isEmpty()){
              res[i]=-1;
          }else res[i]=stack.peek();
           stack.push(a[i]);
       }
        stack=new Stack<>();
        int res1[]=new int[a.length];
        for(int i=0;i<a.length;i++){
            int val=a[i];
            while (!stack.isEmpty() && val  >=stack.peek()) {
                stack.pop();
            }
            if(stack.isEmpty()){
                res1[i]=-1;
            }else res1[i]=stack.peek();
            stack.push(a[i]);

        }
       System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res1));
    }
}
