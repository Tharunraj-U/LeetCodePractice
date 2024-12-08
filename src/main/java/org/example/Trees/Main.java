package org.example.Trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int[] arr = {111,11,12,21,19,119};
//        AVL avl=new AVL();
//        for(int a:arr){
//            avl.insert(a);
//        }
//        avl.levelOrder();
//        System.out.printf("\n %d \n number Of nodes : %d \n",avl.height(),avl.numberOfNodes());
// System.out.println("__________________________________________________");
//        avl.deleteValue(111);
//        avl.deleteValue(11);
//        avl.deleteValue(12);
//        avl.deleteValue(21);
//        avl.levelOrder();


        SegmentTree segmentTree=new SegmentTree(1,2,3,4,5,6,7,8,9,10);
        segmentTree.display();
        System.out.println();
        segmentTree.update(10,5);
        System.out.print( segmentTree.query(0,9));
        int a[]=new int[10];
        SegmentTree segmentTree1=new SegmentTree(a);

    }
}
