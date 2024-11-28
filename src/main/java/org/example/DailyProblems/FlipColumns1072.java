package org.example.DailyProblems;

import java.util.HashMap;

public class FlipColumns1072 {
        public int maxEqualRowsAfterFlips(int[][] m) {
            HashMap<String,Integer> map=new HashMap<>();
            for(int[] a: m){
                StringBuilder str=new StringBuilder();
                for(int val:a){
                    if(a[0]==0){
                        str.append(val);
                    }else{
                        str.append(val == 0?"1":"0");
                    }
                }
                map.put(str.toString(),map.getOrDefault(str.toString(),0)+1);
            }
            int ans=0;
            for(int val:map.values()){
                ans=Math.max(ans,val);
            }
            return ans;
        }
}
