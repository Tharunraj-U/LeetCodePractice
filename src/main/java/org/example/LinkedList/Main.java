package org.example.LinkedList;

public class Main {
    public static void main(String[] args) {
        Singly singly=new Singly();
        for(int i=1;i<=5;i++){
            singly.insert(i);
        }
       singly.head=TodayProblem.reverseAtK(singly.head,2);
        singly.display();

    }
}
