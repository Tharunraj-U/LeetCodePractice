package org.example.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    private class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    private Node root=null;


    public void insert(int data){
        Node newNode=new Node(data);
        if(root==null){
            root=newNode;
            return;
        }
        insertHelper(root,newNode);
        selfBalance(newNode);
    }

    private void selfBalance(Node newNode) {

    }

    private  void insertHelper(Node root1,Node node){
       int rootData=root1.data;
       if(rootData > node.data){
           if(root1.left == null){
               root1.left=node;
               return;
           }
           insertHelper(root1.left,node);
       }
       if(rootData <= node.data){
            if(root1.right == null){
                root1.right=node;
                return;
            }
           insertHelper(root1.right,node);
        }
    }


    public void inOrder(){
        inOrderHelper(root);
    }
    private void inOrderHelper(Node root) {
        if(root != null) {
            inOrderHelper(root.left);
            System.out.print(root.data);
            inOrderHelper(root.right);
        }
    }

    public  void levelOrder(){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node newNode=queue.poll();
            System.out.print(newNode.data+" ");
            if(newNode.left != null){
                queue.add(newNode.left);
            }
            if (newNode.right != null){
                queue.offer(newNode.right);
            }
        }
    }

    public int height(){
        return helperHeight(root);
    }

    private int helperHeight(Node root) {
        if(root == null)return -1;
        int left=helperHeight(root.left);
        int right=helperHeight(root.right);
        return Math.max(right,left)+1;
    }
}
