package org.example.ZohoLevel_2;

class InsertElCircularLinkedList
 {
     class Node{
         int data;
         Node next;
         Node(int data){
             this.data=data;
         }
     }
    public Node sortedInsert(Node head, int data) {
     Node newNode=new Node(data);
     Node temp=head,prev=temp;
     if(head.data > data){
        while(temp.next != head){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.next=head;
        return newNode;
     }                                 
     while(temp.next != head){ // 33 51 52 87
         if(temp.next.data >= data){
             newNode.next=temp.next;
             temp.next=newNode;
             return head;
         }
         prev=temp;
         temp=temp.next;
     }
     if(newNode.next == null){
         temp.next=newNode;
         newNode.next=head;
     }
     return head;
    }
}