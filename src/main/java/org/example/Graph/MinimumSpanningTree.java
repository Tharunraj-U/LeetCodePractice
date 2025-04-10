package org.example.Graph;

import java.util.ArrayList;
import java.util.*;

class MinimumSpanningTree {
    class Node{
        int cost;
        int from,to;
        Node(int from,int to,int cost){
            this.from=from;
            this.to=to;
            this.cost=cost;
        }
        Node(int to,int cost){
             this.to=to;
            this.cost=cost;
        }
    }
    public int minCost(int[][] houses) {
       List<Node> list=new ArrayList<>();
       for(int i=0;i<houses.length;i++){
           for(int j=i+1;j<houses.length;j++){
               int cost=Math.abs(houses[i][0]-houses[j][0])+Math.abs(houses[i][1]-houses[j][1]);
               list.add(new Node(i,j,cost));
           }
       }
        List<List<Node>> graph=new ArrayList<>();
      for(int i=0;i<houses.length;i++){
            graph.add(new ArrayList<>());
        }
        for(Node n:list){
            graph.get(n.from).add(new Node(n.to,n.cost));
            graph.get(n.to).add(new Node(n.from,n.cost));
        }
        int sum=prims(graph,0,-1,new BitSet(),new PriorityQueue<>((a,b)->a.cost-b.cost));
        return sum;
    }
    public int prims(List<List<Node>> list,int curr,int par,BitSet vis,Queue<Node> queue){
        int ans=0;
        queue.offer(new Node(curr,0));
        while(!queue.isEmpty()){
            Node node=queue.poll();
            if(vis.get(node.to))continue;
            ans+=node.cost;
            vis.set(node.to);
            for(Node nei:list.get(node.to)){
                if(!vis.get(nei.to)){
                    queue.offer(nei);
                }
            }
        }
        return ans;
    }
}