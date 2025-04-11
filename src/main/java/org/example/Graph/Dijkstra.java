package org.example.Graph;
import java.util.*;
class Dijkstra {
    public int[] dijkstra(int V, int[][] edges, int src) {
       BitSet vis=new BitSet();
       List<List<int[]>> list=new ArrayList<>();
       for(int i=0;i<V;i++){
           list.add(new ArrayList<>());
       }
       for(int arr[]:edges){
           int u=arr[0],v=arr[1],cost=arr[2];
           list.get(u).add(new int[]{v,cost});
           list.get(v).add(new int[]{u,cost});
       }
       Queue<int[]> queue=new PriorityQueue<>((a,b)-> a[1]-b[1]);
       queue.offer(new int[]{src,0});
       int dis[]=new int[V];
       Arrays.fill(dis,-1);
       while(!queue.isEmpty()){
            int node[]=queue.poll();
            if(vis.get(node[0]))continue;
             dis[node[0]]=node[1];
            vis.set(node[0]);
            for(int nei[]:list.get(node[0])){
                if(!vis.get(nei[0])){
                    queue.offer(new int[]{nei[0],nei[1]+node[1]});
                }
            }
       }
       return dis;
    }
}