package org.example;

class MyCircularDeque {
    class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    int size=0;
    int length=0;


    Node tail=null,head=null;
    public MyCircularDeque(int k) {
        size=k;
    }

    public void print(){
        Node temp=head;
        if( length==1){
            System.out.print(temp.val+ " ");
            System.out.println( "___________");
            return;
        }
        System.out.print(temp.val+ " ");
        temp=temp.next;
        while(temp != head){
            System.out.print(temp.val+ " ");
            temp=temp.next;

        }
        System.out.println( "___________");
    }

    public boolean insertFront(int value) {
        if( length < size ){

            Node node=new Node(value);
            if(length == 0){
                tail=node;
                head=node;
                tail.prev=tail;
                head.prev=tail;
                head.next=head;
                tail.next=head;
            }
            else{
                node.next=head;
                node.prev=tail;
                head.prev=node;
                tail.prev=node;
                head=node;

            }
            length++;
            print();
            return true;

        }
        return false;
    }

    public boolean insertLast(int value) {
        if( length < size ){

            Node node=new Node(value);
            if(length == 0){
                tail=node;
                head=tail;
                tail.next=head;
                tail.prev=tail;
            }
            else{
                node.next=head;
                node.prev=tail;
                head.prev=node;
                tail.next=node;
                tail=node;

            }
            length++; print();
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if( length > 0){
            if(length == 1){
                tail=null;head=null;
            }
            else{
                tail.next=head.next;
                head=head.next;
                head.prev=tail;

            }
            length--; print();
            return true;

        }
        return false;
    }

    public boolean deleteLast() {

        if( length > 0){

            if(length == 1){
                tail=null;head=null;
            }
            else{
                tail=tail.prev;
                tail.next=head;
                head.prev=tail;



            }
            length--; print();
            return true;

        }
        return false;
    }

    public int getFront() {
        if( length >0){
            return head.val;
        }
        return -1;
    }

    public int getRear() {
        if( length >0){
            return tail.val;
        }
        return -1;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == size;
    }
}


