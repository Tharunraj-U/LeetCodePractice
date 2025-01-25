package org.example.LinkedList;

public class Singly {
     public static class  Node{
         int val;
         Node next;
         Node (int val){
             this.val=val;
             next=null;
         }
    }
    public  Node head=null;
     private  Node tail=null;
     private  int height=0;

     public void insert(int data){
         Node newNode=new Node(data);
         if(head == null){
             head=newNode;
             tail=head;

         }else{
             tail.next=newNode;
             tail=newNode;
         }
     }
     public  void display(){
         Node temp=head;
         while (temp != null){
             System.out.print(temp.val);
             temp=temp.next;
         }
     }
     public  void reverse(){
         Node prev=null;
         Node curr=head;
         Node fast=head;
         while ( fast !=  null &&  fast.next != null){
             fast=fast.next.next;
             Node  next=curr.next;
             curr.next=prev;
             prev=curr;
             curr=next;
         }
         head.next=curr;
         head=prev;
     }
}
