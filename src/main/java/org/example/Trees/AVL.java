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
        root=insertHelper(root,newNode);
    }

    private Node selfBalance(Node newNode) {

        int balanceFacter=getBalanceFacter(newNode.left,newNode.right);
        if(balanceFacter < -1){
            if(helperHeight(newNode.right) > 0) {
               newNode.right=rightRotate(newNode.right);
            }
            return leftRotate(newNode);
        }
        if(balanceFacter > 1){
            if(helperHeight(newNode.left) < 0) {
                newNode.left=leftRotate(newNode.left);
            }
            return rightRotate(newNode);
        }
        return  newNode;

    }
    private  Node leftRotate(Node parent){
        Node newParent=parent.right;
        Node newParentChild=newParent.left;

        newParent.left=parent;
        parent.right=newParentChild;
        return  newParent;
    }
    private  Node rightRotate(Node parent){
        if (parent.left == null) {
            return parent; // No need to rotate if left child is null
        }
        Node newParent=parent.left;
        Node newParentChild=newParent.right;
        newParent.right=parent;
        parent.left=newParentChild;
        return  newParent;
    }

    private int getBalanceFacter(Node left, Node right) {
        return helperHeight(left)-helperHeight(right);
    }

    private  Node insertHelper(Node root1,Node node){
        if(root1 == null){
            return  node;
        }
        if(root1.data  > node.data){
            root1.left=insertHelper(root1.left,node);
        }
        if(root1.data <= node.data){
            root1.right=insertHelper(root1.right,node);
        }
       return  selfBalance(root1);
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
    public  int numberOfNodes(){

        return ( 1 << (helperHeight(root)+1))-1;
    }
}
