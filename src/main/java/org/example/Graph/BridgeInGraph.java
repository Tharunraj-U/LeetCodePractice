package org.example.Graph;

import java.util.*;

class BridgeInGraph {
    int timer=1;
    public  void dfs(List<List<Integer>> list, int curr, int par, BitSet vis, int[] high, int low[], List<List<Integer>> ans){
        vis.set(curr);
        high[curr]=low[curr]=timer++;
        for(int nei:list.get(curr)){
            if(nei == par)continue;
            if(!vis.get(nei)){
                dfs(list,nei,curr,vis,high,low,ans);
                if(low[nei] > high[curr]){
                    ArrayList<Integer> list1=new ArrayList<>();
                    list1.add(nei);
                    list1.add(curr);
                    ans.add(list1);
                }
            }
            low[curr]=Math.min(low[curr],low[nei]);
        }
        
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> con) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(List<Integer> arr:con){
            list.get(arr.get(1)).add(arr.get(0));
            list.get(arr.get(0)).add(arr.get(1));
        }
        List<List<Integer>> ans=new ArrayList<>();
        BitSet vis=new BitSet();
        int high[]=new int[n];
        int low[]=new int[n];
        dfs(list,0,-1,vis,high,low,ans);
        return ans;
    }
}