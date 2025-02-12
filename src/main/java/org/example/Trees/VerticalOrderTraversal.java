package org.example.Trees;

import java.util.*;

public class VerticalOrderTraversal {

       public class TreeNode {
           int val;
           TreeNode left;
           TreeNode right;
           TreeNode() {}
           TreeNode(int val) { this.val = val; }
           TreeNode(int val, TreeNode left, TreeNode right) {
               this.val = val;
               this.left = left;
               this.right = right;
           }
       }
    class Solution {
        class Data{
            TreeNode val;
            int col;
            int level;
            Data(TreeNode val,int col,int level){
                this.val=val;
                this.col=col;
                this.level=level;
            }
        }
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> ans=new ArrayList<>();
            TreeMap<Integer,List<int[]>> map=new TreeMap<>();
            Queue<Data> queue=new LinkedList<>();
            queue.offer(new Data(root,0,0));
            while(!queue.isEmpty()){
                int n=queue.size();
                for(int i=0;i<n;i++){
                    Data data=queue.poll();
                    if(!map.containsKey(data.col)){
                        map.put(data.col,new ArrayList<>());
                    }
                    map.get(data.col).add(new int[]{data.level,data.val.val});
                    if(data.val.left != null){
                        queue.offer(new Data(data.val.left,data.col-1,data.level+1));
                    }
                    if(data.val.right != null){
                        queue.offer(new Data(data.val.right,data.col+1,data.level));
                    }
                }

            }
            for(List<int[]> list:map.values()){
                list.sort((a,b)->{
                    if(a[0] == b[0]) return Integer.compare(a[1],b[1]);
                    return Integer.compare(a[0],b[0]);
                });
                List<Integer> list1=new ArrayList<>();
                for(int val[]:list){
                    list1.add(val[1]);
                }
                ans.add(list1);
            }
            return ans;
        }
    }
}
