package org.example.Graph;
import java.util.*;
class TopoSortSolution {
    public static  void dfs(List<List<Integer>> list,BitSet vis,ArrayList<Integer> ans,int i){
        vis.set(i);
       
        for(Integer nei:list.get(i)){
            if(!vis.get(nei)){
                dfs(list,vis,ans,nei);
            }
        }
        ans.add(i);
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
       ArrayList<Integer>  ans=new ArrayList<Integer>();
       List<List<Integer>> list=new ArrayList<>();
       for(int i=0;i<V;i++){
           list.add(new ArrayList<>());
       }
       for(int a[]:edges){
           list.get(a[0]).add(a[1]);
       }
       BitSet vis=new BitSet();
       for(int i=0;i<V;i++){
           if(!vis.get(i)){
               dfs(list,vis,ans,i);
               
           }
       }
       Collections.reverse(ans);
       return ans;
    }
}