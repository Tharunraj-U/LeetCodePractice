package org.example.Graph;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

class UndirectedGraphCycleDfs {
    public boolean dfs(List<List<Integer>> graph, BitSet vis, int curr, int[] par, int p){
        par[curr]=p;
        vis.set(curr);
        for(Integer nei:graph.get(curr)){
             if(!vis.get(nei)){
                  if(dfs(graph,vis,nei,par,curr)==true)return true;
             }else if(nei != p )return true;
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
       List<List<Integer>> graph=new ArrayList<>();
       for(int i=0;i<V;i++){
           graph.add(new ArrayList());
       }
       for(int ar[]:edges){
           int u=ar[0];
           int v=ar[1];
           graph.get(u).add(v);
           graph.get(v).add(u);
       }
       BitSet vis=new BitSet();
       int par[]=new int[V];
       for(int i=0;i<V;i++){
           if(!vis.get(i)){
               if(dfs(graph,vis,i,par,-1)){
                   return !false;
               }
           }
       }
       return !true;
    }

    public static void main(String[] args) {

    }
}