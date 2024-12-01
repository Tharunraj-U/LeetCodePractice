package org.example.Trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree2 binaryTree2=new BinaryTree2();
        Scanner scanner=new Scanner(System.in);
        binaryTree2.create(scanner);
        binaryTree2.levelOrder(binaryTree2.root);
        binaryTree2.levelOrder1(binaryTree2.root);
    }
}
