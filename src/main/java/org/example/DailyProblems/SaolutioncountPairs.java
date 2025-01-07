package org.example.DailyProblems;

import java.util.HashMap;

class  SaolutioncountPairs{

    int SolutioncountPairs(int arr[], int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
       for(int i:arr){
           map.put(i,map.getOrDefault(i,0)+1);
       }
       int ans=0;
       for(int i=0;i<arr.length;i++){
           int newVal=target-arr[i];
           if(map.containsKey(i)){
               if(newVal == arr[i]){
                   ans+=map.get(map.containsKey(i))-1;
               }else{
                    ans+=map.get(map.containsKey(i));
               }
           }
           
       }
       return ans/2;
    }
}
