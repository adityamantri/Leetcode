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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse starting slow
        ListNode curr = slow;
        ListNode prev = null;
        // slow.next = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // slow is the last head
        ListNode first = head, second = prev;
        while(second.next != null && first.next != second){
            ListNode fNext = first.next;
            ListNode sNext = second.next;// 3, 3
            first.next = second;//2->4
            second.next = fNext;// 4->3
            first = fNext;//3
            second = sNext;//3
        }
    }
}
/**
1. find mid of the list using slow and fast ptr
2. reverse second half of the list
3. we have 2 heads
    Move ptr from last to 
    while(start != end)
    Node nextEnd = end.next;
    Node nextStart = start.next;
    start.next = end;
    end.next = nextStart;
    start = nextStart;
    end = nextEnd;
*/