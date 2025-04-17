package org.example.Graph;

import java.util.*;

class MinimumWeightCycle {
    public class Pair{
        int node;
        int weight;
        Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int dijikstra(Map<Integer, List<Pair>> graph, int s, int e){
        Queue<Pair> minHeap=new  PriorityQueue<>((a,b)-> a.weight-b.weight);
        minHeap.offer(new Pair(s,0));
        BitSet vis=new BitSet();
        while(!minHeap.isEmpty()){
            Pair pair=minHeap.poll();
             if (vis.get(pair.node)) continue;
            vis.set(pair.node);
           
            if(pair.node ==e){
                return pair.weight;
            }
            if(graph.containsKey(pair.node)){
                for(Pair p:graph.get(pair.node)){
                if(!vis.get(p.node)){
                   minHeap.offer(new Pair(p.node,p.weight+pair.weight)); 
                }
            }
            }
        }
        return Integer.MAX_VALUE;
    }
    public int findMinCycle(int V, int[][] edges) {
    Map<Integer,List<Pair>> map=new HashMap<>();
       for(int i=0;i<V;i++){
         map.put(i,new ArrayList<>());   
       }
       for(int arr[]:edges){
           int u=arr[0];
           int v=arr[1];
           int c=arr[2];
           map.get(u).add(new Pair(v,c));
           map.get(v).add(new Pair(u,c));
       }
       
       int min=Integer.MAX_VALUE;
        for(int arr[]:edges){
           int u=arr[0];
           int v=arr[1];
           int c=arr[2];
           List<Pair> temp1=new ArrayList<>(map.get(u));
           List<Pair> temp2=new ArrayList<>(map.get(v));
            
            map.get(u).removeIf(node -> node.node == v);
            map.get(v).removeIf(node -> node.node == u);
            int dis=dijikstra(map,u,v);
            if(dis != Integer.MAX_VALUE){
               min=Math.min(min,dis+c); 
            }
            map.put(u,temp1); 
            map.put(v,temp2); 
         
       }
       return min;
    }
};