package org.example.Trees;

public class SegmentTree {
    private  class Node{
        int sum;
        int leftMostIndex;
        int rightMostIndex;
        Node left,right;

        public Node(int leftMostIndex,int rightMostIndex){
            this.leftMostIndex=leftMostIndex;
            this.rightMostIndex=rightMostIndex;
            left=null;
            right=null;
        }
    }
    private Node root;
    SegmentTree(int...arr){
          this.root=constructTree(arr,0,arr.length-1);
    }
    public  Node constructTree(int[] arr,int start,int end){
        if(start==end){
            Node leaf=new Node(start,end);
            leaf.sum=arr[start];
            return leaf;
        }
        Node node=new Node(start,end);
        int mid=(start+(end-start)/2);
        node.left=this.constructTree(arr,start,mid);
        node.right=this.constructTree(arr,mid+1,end);
        node.sum=node.left.sum+node.right.sum;
        return node;
    }

    public void display(){
         display(root);
    }
    private void display(Node node){
        if(node != null){
            display(node.left);
            System.out.print(node.sum+" ");
            display(node.right);
        }
    }
    public int query(int startIndex,int endIndex){
        return query(startIndex,endIndex,root);
    }
    private   int query(int start,int end,Node node){
        if(  node.rightMostIndex  < start || end  < node.leftMostIndex){
            return 0;
        }
        if( node.leftMostIndex >= start &&  node.rightMostIndex <= end){
            return node.sum;
        }
        return query(start,end,node.left)+query(start,end,node.right);
    }

    public void update(int index,int val){
        update(root,index, val);
    }

    private Node update(Node node ,int index,int val){
        if(index >= node.leftMostIndex && index <= node.rightMostIndex){
            if(index == node.leftMostIndex && index == node.rightMostIndex){
                node.sum=val;
                return  node;
            }
             Node leftSum=update(node.left,index,val);
            Node rightSum=update(node.right,index,val);
            node.sum=leftSum.sum+rightSum.sum;
        }
        return  node;
    }
}
