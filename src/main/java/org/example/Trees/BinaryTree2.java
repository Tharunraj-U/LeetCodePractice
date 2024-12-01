package org.example.Trees;


import java.util.Scanner;

public class BinaryTree2  extends  BinaryTree{

    public   BinaryTree.Node root;
    public void create(Scanner scanner){
       System.out.print("Enter the root node");
       int val=scanner.nextInt();
       root=new Node(val);
       fillRemaining(scanner,root);
    }

    private void fillRemaining(Scanner scanner, BinaryTree.Node node) {
        System.out.printf("Do you want to enter the left child  for the %d",node.val);
        boolean left=scanner.nextBoolean();
        if(left){
            System.out.print("Enter the data");
            int val=scanner.nextInt();
            Node newNode=new Node(val);
            node.left=newNode;
            fillRemaining(scanner,newNode);
        }
        System.out.printf("Do you want to enter the  right child  for the %d",node.val);
        boolean right=scanner.nextBoolean();
        if(right){
            System.out.print("Enter the data");
            int val=scanner.nextInt();
            Node newNode=new Node(val);
            node.right=newNode;
            fillRemaining(scanner,newNode);
        }
    }
    public void levelOrder(Node root){
        int h=findHeight(this.root);
        for(int i=1;i<=h;i++){
            helper(this.root,i);
        }
    }

    private int  findHeight(Node node){
        if(node==null)return 0;
        int right=findHeight(node.right);
        int left=findHeight(node.left);
        return Math.max(right,left)+1;
    }

    public  void helper(Node node,int level){
        if(node==null)return;
        if(level == 1) System.out.print(node.val+" ");
         else if ( level > 1){
             helper(node.left,level-1);
             helper(node.right,level-1);

        }
    }

}
