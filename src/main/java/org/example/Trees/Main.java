package org.example.Trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 5, 2, 0};
        AVL avl=new AVL();
        for(int a:arr){
            avl.insert(a);
        }
        avl.levelOrder();
        System.out.printf("\n %d",avl.height());


    }
}
