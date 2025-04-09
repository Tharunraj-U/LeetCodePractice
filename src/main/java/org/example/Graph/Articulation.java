package org.example.Graph;

import java.util.*;

class Articulation {
     static int timer=1;
    public static  void dfs(int curr, int par, List<List<Integer>> list, BitSet vis, int [] high, int []low, boolean node[]){
        vis.set(curr);
        high[curr]=low[curr]=timer++;
        int c=0;
        for(int nei:list.get(curr)){
            if(nei==par)continue;
            
            if(!vis.get(nei) ){
                c++;
                dfs(nei,curr,list,vis,high,low,node);
                low[curr]=Math.min(low[nei],low[curr]);
                if(low[nei] >= high[curr] && par !=-1 ){
                    node[curr]=true;
                }
            }else{
            low[curr]=Math.min(high[nei],low[curr]);
            }
        }
        if(c > 1 && par ==-1){
            node[curr]=true;
        }
    }
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<Integer> ans=new ArrayList<>();
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }
        for(int arr[]:edges){
            list.get(arr[0]).add(arr[1]);
            list.get(arr[1]).add(arr[0]);
        }
        boolean node[]=new boolean[V];
        BitSet vis=new BitSet();
        int []high=new int[V];
        int low[]=new int[V];
        for(int i=0;i<V;i++){
            if(!vis.get(i)){
              dfs(i,-1,list,vis,high,low,node);
            }
        }
        int i=0;
        for(boolean b:node){
            if(b)ans.add(i);
            i++;
        }
        
        return ans.size() > 0 ? ans : new ArrayList<>(List.of(-1));
        
    }
}