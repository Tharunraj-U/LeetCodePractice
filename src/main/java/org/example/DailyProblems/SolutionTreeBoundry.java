package org.example.DailyProblems;


import java.util.ArrayList;
import java.util.Stack;
class Node
{
    public Node next;
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
class SolutionTreeBoundry {
    void addRight(ArrayList<Integer> list, Node root){
          Stack<Integer> stack=new Stack<>();
       if(root == null)return;
        root=root.right;
        while(root !=null &&  !isLeaf(root)){
            stack.push(root.data);
            root= root.right != null ? root.right : root.left;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
       
    }
   void addLeft(Node root, ArrayList<Integer> list) {
    if (root == null) return; // Base case
    
    Node curr = root; // Start from left child
    while (curr != null && !isLeaf(curr)) {
        list.add(curr.data); // Store the left boundary node
        curr = (curr.left != null) ? curr.left : curr.right; // Move to left first, then right
    }
}

    boolean isLeaf(Node root){
       return root.right == null && root.left == null;
    }
     void addLeaf(Node root,ArrayList<Integer> list){
         if(root == null)return;
             addLeaf(root.left,list);
             if(isLeaf(root)){
                 list.add(root.data);
             }
             addLeaf(root.right,list);
     }
    ArrayList<Integer> boundaryTraversal(Node root) {
       ArrayList<Integer> list=new ArrayList<>();
       if(root == null)return list;
       if(root.left == null && root.right == null){
           list.add(root.data);
           return list;
       }
       Node root1=root;
       Node temp=root;
       
      
       list.add(root.data);
       addLeft(temp.left,list);
       addLeaf(root,list);
       addRight(list,root1);
       return list;
    }
}