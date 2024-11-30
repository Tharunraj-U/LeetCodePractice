package org.example.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private  static   class Node{
        private int val;
         public  Node left;
         public Node right;
         Node(int val){
             this.val=val;
             left=null;right=null;
         }
    }
    private Node root;
    public  void insert(int data){
        Node newNode=new Node(data);
        if(root==null){
            root=newNode;
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node1 = queue.poll();
            if (node1.left == null) {
                node1.left = newNode;
                return;
            } else {
                queue.add(node1.left);
            }
            if (node1.right == null) {
                node1.right = newNode;
                return;
            } else {
                queue.add(node1.right);
            }
        }

    }
    public void  display(Node node){
        if(node != null) {
            display(node.left);
            System.out.print(node.val);
            display(node.right);
        }
    }

    public static void main(String[] args) {
      BinaryTree binaryTree=new BinaryTree();
        int i=10;
      while(i > 0){
            binaryTree.insert(i);
            i--;
        }
       binaryTree.display(binaryTree.root);
    }

}
