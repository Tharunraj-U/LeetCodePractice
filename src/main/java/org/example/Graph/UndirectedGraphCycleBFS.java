package org.example.Graph;
import java.util.*;

class UndirectedGraphCycleBFS {
    public boolean bfs(List<List<Integer>> graph, int c, BitSet vis){
       Queue<int[]> queue=new LinkedList<>();
       queue.offer(new int[]{c,-1});
       while(!queue.isEmpty()){
           int node[]=queue.poll();
           int curr=node[0];
           int par=node[1];
           vis.set(curr);
           for(int nei:graph.get(curr)){
               if(!vis.get(nei)){
                   queue.offer(new int[]{nei,curr});
               }else if(par != nei)return true;
           }
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
      for(int i=0;i<V;i++){
          if(!vis.get(i)){
              if(bfs(graph,i,vis))return true;
          }
      }
      return false;
}
}