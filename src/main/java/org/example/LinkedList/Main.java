package org.example.LinkedList;

public class Main {
    public static void main(String[] args) {
        Singly singly=new Singly();
        for(int i=1;i<=10;i++){
            singly.insert(i);
        }
        singly.reverse();
        singly.display();
    }
}
