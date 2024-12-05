package org.example.Trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,1,1};
        AVL avl=new AVL();
        for(int a:arr){
            avl.insert(a);
        }
        avl.levelOrder();
        System.out.printf("\n %d \n number Of nodes : %d",avl.height(),avl.numberOfNodes());


    }
}
