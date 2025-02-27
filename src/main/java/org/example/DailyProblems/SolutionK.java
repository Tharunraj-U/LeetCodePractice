package org.example.DailyProblems;

import java.util.Stack;

class SolutionK {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    // Constructor
    public SolutionK() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Add an element to the top of Stack
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // Remove the top element from the Stack
    public void pop() {
        if (!stack.isEmpty()) {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }
    }

    // Returns top element of the Stack
    public int peek() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1; // Return -1 if stack is empty (handle accordingly)
    }

    // Finds minimum element of Stack
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1; // Return -1 if stack is empty (handle accordingly)
    }
}