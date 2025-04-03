package org.example.DailyProblems;

import java.util.ArrayDeque;
import java.util.Deque;

class SolutionMaxSlidingWindow {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int ans[]=new int[arr.length+1-k];
        int j=0;
        Deque<Integer> queue=new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            if(!queue.isEmpty() && queue.peekFirst() <= i-k){
                queue.removeFirst();
            }
            while(!queue.isEmpty()  && arr[queue.peekLast()] <=arr[i]){
                 queue.removeLast();
            }
            queue.offer(i);
            if(i >=k-1){
                ans[j++]=(arr[queue.peekFirst()]);
            }
        }  
        return ans;

    }
}