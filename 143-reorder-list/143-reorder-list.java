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
    *   create half reverse
    */
    public void reorderList(ListNode head) {
        ListNode mid = getMid(head, head);
                System.out.println(mid.val);

        ListNode last = reverse(null, mid);

        //Iterate 
        ListNode start = head;
        while(start.next != last && start != last){
            ListNode next = start.next;
            ListNode lastNext = last.next;
            start.next = last;
            start = next;
            next = last.next;
            last.next = start;
            last = next;
        }
        
    }
    
    public ListNode getMid(ListNode slow, ListNode fast){
        while(fast != null && fast.next != null){
            // System.out.print(slow.val + " "+fast.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode prev, ListNode curr){
        while(curr!= null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}