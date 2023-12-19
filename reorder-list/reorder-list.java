/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
        1. find mid
        2. reverse from mid
        3. reconnect pointers in interleaving fashion from both heads until mid
        4. mid.next = null
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        // find mid
        ListNode slow = head, fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode ptr = slow, prev = null;
        while(ptr != null){
            ListNode next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }
        
        // merge
        ListNode second = prev, first = head;
        while(second.next != null){
            ListNode next = first.next;
            first.next = second;
            first = next;

            next = second.next;
            second.next = first;
            second = next;
        }

    }
}