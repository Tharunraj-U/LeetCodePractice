package org.example.DailyProblems;

import java.util.PriorityQueue;
import java.util.Queue;

class MinimumTime {
    
    public static int minTimeToReach(int[][] m) {
        class Node{
        int i,j,cost,time;
        Node(int i,int j,int cost,int time){
            this.i=i;
            this.j=j;
            this.cost=cost;
            this.time=time;
        }
    }
         Queue<Node> queue=new PriorityQueue<>((a, b)-> a.time-b.time);
         queue.offer(new Node(0,0,1,0));
         boolean vis[][]=new boolean[m.length][m[0].length];
         int dis[][]={{1,0},{-1,0},{0,1},{0,-1}};
         while(!queue.isEmpty()){
            Node node=queue.poll();
             System.out.println(node.cost+" "+node.time+" "+node.i+" "+node.j);
            if(node.i == m.length-1 && node.j == m[0].length-1){
                return node.time;
            }
            if(vis[node.i][node.j])continue;
            vis[node.i][node.j]=true;
           
            for(int arr[]:dis){
                int newi=node.i+arr[0];
                int newj=node.j+arr[1];
                if(newi > -1 && newj > -1 && newi < m.length && m[0].length > newj && !vis[newi][newj]){
                    int time=Math.max(node.time,m[newi][newj])+node.cost;
                    int cost= node.cost == 1 ? 2 :1;
                    queue.offer(new Node(newi,newj,cost,time));
                }
            }

         }
         return -1;
    }

    public static void main(String[] args) {
        int arr[][]={{0,4},{4,4}};
        System.out.println(minTimeToReach(arr));
    }
}