package org.example.DailyProblems;

class SolutionFindFirstNode {
    // Function to remove a loop in the linked list.
     public static Node findFirstNode(Node head) {
        Node slow=head,fast=head;
        while(fast != null){
            slow=slow.next;
            if(fast == null || fast.next == null || fast.next.next == null){
                return null; 
            }
            fast=fast.next.next;
            if(slow == fast){
                slow=head;
                while(slow != fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void removeLoop(Node head) {
         Node temp=findFirstNode(head);
         if(temp == null)return;
         Node start=temp;
         while(start.next != temp ){
             start=start.next;
             
         }
         start.next=null;
    }
}