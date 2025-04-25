package org.example.ZohoLevel_2;

class InsertElCircularLinkedList {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);

        // Case 1: Empty list
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;

        // Case 2: Inserting before head (new minimum)
        if (data < head.data) {
            // Find the last node (which points to head)
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.next = head;
            return newNode;  // new head
        }

        // Case 3: Insert somewhere after head
        while (curr.next != head && curr.next.data < data) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        return head; // head remains unchanged
    }
}
