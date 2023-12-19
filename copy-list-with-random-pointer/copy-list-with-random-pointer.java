/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node prevHead = new Node(-1, head);
        Node ptr = head;
        // create a copy infront of each element
        while(ptr != null){
            Node next = ptr.next;
            Node copy = new Node(ptr.val);
            ptr.next = copy;
            copy.next = next;
            ptr = next;
        }
        Node copyHead = head.next;
        // copy the random ptr
        ptr = head;
        while(ptr != null){
            Node copyPtr = ptr.next;
            if(ptr.random != null)
                ptr.next.random = ptr.random.next;
            ptr = ptr.next.next;
        }

        // separate the lists
        ptr = head;
        while(ptr != null){
            Node copy = ptr.next;
            ptr.next = ptr.next.next;
            if(copy.next != null)
                copy.next = copy.next.next;
            ptr = ptr.next;
        } 
        return copyHead;
    }
}