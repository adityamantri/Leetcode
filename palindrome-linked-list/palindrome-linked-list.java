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
     * 1. Find Mid point
     * 2. Reverse from mid to end
     * 3. Compare start and end moving inwards
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null) 
            return true;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast != null){
            slow = slow.next;
        }
        
        // slow is at mid point, now reverse
        ListNode last = reverse(slow);
        fast = head;
        
        while(last!= null){
            if(fast.val != last.val){
                return false;
            }
            fast = fast.next;
            last = last.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode node){
        ListNode prev = null;
        while(node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}