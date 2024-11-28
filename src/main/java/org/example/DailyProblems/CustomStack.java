package org.example.DailyProblems;

import java.util.Arrays;

class CustomStack {
    int stack[];
    int top;
    public CustomStack(int maxSize) {
        stack=new int[maxSize];
        top=-1;
    } 
    
    public void push(int x) {
       
        if(top < stack.length-1){
            
            stack[++top]=x;
             Arrays.stream(stack).forEach(e-> System.out.print(e+" "));
             System.out.println();
            
       
    }}
    
    public int pop() {

        return top>=0 ? (stack[top--]): -1;
       
    }
    
    public void increment(int k, int val) {
     
        for(int i=0;i<=top;i++){
            if(k==stack[i]){
              stack[i]+=val;
                System.out.println("Updated value at index " + i + ": " + stack[i]);
              return;  
            }
        }
        for(int i=0;i<=top;i++){
           
              stack[i]+=val;
            System.out.println("Updated value at index " + i + ": " + stack[i]);
             
        }
        

    }

    public static void main(String[] args) {

            CustomStack customStack = new CustomStack(5);
            customStack.push(10);
            customStack.push(20);
            customStack.push(30);

            // Attempt to update the stack
            customStack.increment(20, 5);  // This should update the element at index 1
            customStack.increment(40, 5);  // This should add 5 to all elements
        }

    }
