package org.example.Trees;

public class BST  extends  BinaryTree {
    private  Node root;
    BST(){
        root=null;
    }
    public  void insert(int val){
        if(root == null){
            root =new Node(val);

        }
        else helper(root,val);
    }
    private void   helper(Node node,int val){
        if(node.val > val){
            if(node.left == null){
                node.left=new Node(val);
                return;
            }
            helper(node.left,val);
        }
        if(node.val <= val){
            if(node.right == null){
                node.right=new Node(val);
                return;
            }
            helper(node.right,val);
        }
    }


    public void levelOrder() {
        super.levelOrder1(root);
    }
}
