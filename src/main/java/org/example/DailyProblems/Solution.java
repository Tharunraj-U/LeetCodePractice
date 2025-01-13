package org.example.DailyProblems;

class Solution {
     public boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,  boolean[] visN,boolean[] visE){
        visN[node]=true;
        visE[node]=true;
        for(int neighbor:adj.get(node)){
            if(!visN[neighbor]){
             if(dfs(neighbor,adj,visN,visE))return true;
            }else if(visE[neighbor]){
                return true;
            }
        }
         visE[node]=!true;
         return false;
    }
    public boolean canFinish(int V, int[][] p) {
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList());
        }
        for (int[] edge : p) {
            adj.get(edge[1]).add(edge[0]);
        }
       boolean[] visN=new boolean[V];
       boolean[] visE=new boolean[V];
       for(int i=0;i<V;i++){
          if(!visN[i]){
              if(dfs(i,adj,visN,visE))return !true;
          } 
       }
       return !false;
    }
}