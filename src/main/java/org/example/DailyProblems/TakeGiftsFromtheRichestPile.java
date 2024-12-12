package org.example.DailyProblems;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class TakeGiftsFromtheRichestPile {
    public long pickGifts(int[] gifts, int k) {

        Queue<Integer> list=new PriorityQueue<>(Collections.reverseOrder());
        for(int a:gifts){
            list.add(a);
        }
        while(k >0){
            k--;
            if(!list.isEmpty()){
                int a=list.poll();
                list.offer((int)Math.floor((int)Math.sqrt(a)));
            }
        }
        long ans=0;
        for(int a:list){
            ans+=a;
        }

        return ans;
    }
}