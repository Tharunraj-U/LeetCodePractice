package org.example.Trees;

import org.example.ZohoLevel_3.Main;

public class SegmentII {
    private  class  Node{
        int leftIndex;
        int rightIndex;
        int value;
        Node left=null;
        Node right=null;
        Node(int leftIndex,int rightIndex){
            this.leftIndex=leftIndex;
            this.rightIndex=rightIndex;
        }
        Node(int leftIndex,int rightIndex,int value){
            this.leftIndex=leftIndex;
            this.rightIndex=rightIndex;
            this.value=value;
        }
    }

    public Node constructTree(int arr[],int left,int right){
        if(left==right){
            return new Node(left,right,arr[left]);
        }
        int mid=left+(right-left)/2;
        Node node=new Node(left,right);
        node.left=constructTree(arr,left,mid);
        node.right=constructTree(arr,mid+1,right);
        node.value= Math.max(node.right.value,node.left.value);
        return node;
    }

    public void printTree(Node root){
        if(root != null) {
            System.out.println(root.leftIndex + "  " + root.value + "  " + root.rightIndex);
            printTree(root.left);
            printTree(root.right);
        }
    }

    public int getValueFromRange(Node root,int i,int j){
        if(root.rightIndex == i && root.leftIndex == j){
            return root.value;
        }
//        if(  node.rightMostIndex  < start || end  < node.leftMostIndex){
//            return 0;
//        }
        if(root.rightIndex < i || root.leftIndex > j){
            return  Integer.MIN_VALUE;
        }
        int mid=i+(j-i)/2;
        return Math.max(getValueFromRange(root,i,mid),getValueFromRange(root,mid+1,j));
    }


    public static void main(String[] args) {
        SegmentII segmentII=new SegmentII();
        int arr[]={1,2,3,4,5,6};
       Node root=segmentII.constructTree(arr,0,arr.length-1);
       System.out.println(segmentII.getValueFromRange(root,0,4));

    }

}
