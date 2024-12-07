package org.example.Trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = {111,11,12,21,19,119};
        AVL avl=new AVL();
        for(int a:arr){
            avl.insert(a);
        }
        avl.levelOrder();
        System.out.printf("\n %d \n number Of nodes : %d \n",avl.height(),avl.numberOfNodes());
 System.out.println("__________________________________________________");
        avl.deleteValue(111);
        avl.deleteValue(11);
        avl.deleteValue(12);
        avl.deleteValue(21);
        avl.levelOrder();


    }
}
