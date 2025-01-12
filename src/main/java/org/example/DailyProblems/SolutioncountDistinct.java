package org.example.DailyProblems;

import java.util.ArrayList;
import java.util.HashMap;

class SolutioncountDistinct {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        int c=0;
        ArrayList<Integer> ans=new ArrayList<Integer>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(i>k){
                map.put(arr[i],map.getOrDefault(arr[i],0)-1);
                int ans1=0;
                for(int val:map.keySet()){
                   if(val > 0){
                        ans1+=val;
                   }
                }
                ans.add(ans1);
            }
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            
        }
        return null;
    }
}
