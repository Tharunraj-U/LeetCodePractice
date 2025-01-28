package org.example.LinkedList;

public class TodayProblem extends Singly {
    public static Node reverseKGroup(Node head, int k) {
        Node dummy=new Node(0);
        Node dummy1=new Node(0);
        dummy.next=head;
        dummy1.next=head;
        Node  prevG=dummy,nextG=null;
        while(true){
            Node start=prevG.next;

            Node end=prevG.next;
            for(int i=1;i<k && end !=null && end.next != null   ;i++){
                end=end.next;
            }
            if(end == null ){
                break;
            }

            nextG=end.next;
            reverse(start,end);
            start.next=nextG;
            prevG.next=end;
            prevG=start;

        }
        return dummy;
    }
    public  static void reverse(Node start,Node end){
        Node prev=null,curr=start;
        while(prev != end){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
    }
    public static Node reverseAtK(Node head, int k) {
        Node start=head,end=head;
        for(int i=1;i<k && end != null && end.next != null;i++){
            end=end.next;
        }
        if(end == null){
            return rev(head,end);
        }
        Node next=end.next,firstGL=head;
        head=rev(head,end);
        Node last=rev1(next
        );
        firstGL.next=last;
        return head;
    }
    public static Node rev(Node start,Node end){
        Node prev=null,curr=start;
        while(prev != end ){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public static Node rev1(Node start){
        Node prev=null,curr=start;
        while(curr != null ){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
