package org.example.Trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      BST bst=new BST();
      for(int i=0;i<10;i++){
          bst.insert(i);
      }
        bst.insert(-10);bst.insert(-1);
      bst.levelOrder();
    }
}
