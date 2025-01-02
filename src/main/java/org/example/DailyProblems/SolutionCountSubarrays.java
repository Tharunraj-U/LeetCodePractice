package org.example.DailyProblems;

import java.util.HashMap;
import java.util.Map;

class SolutionCountSubarrays {
    public int countSubarrays(int arr[], int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0,c=0;
        for(int a:arr){
            sum+=a;
            if(map.containsKey(sum-k))c+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return c;
    }
}