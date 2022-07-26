/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode startA = headA, startB = headB;
        int a = 0, b = 0;
        while(startA != null || startB != null){
            if(startA != null){
                startA = startA.next;
                a++;
            }
            if(startB != null){
                startB = startB.next;
                b++;
            }
        }
        startA = headA; startB = headB;
        while(a != b){
            if(a > b){
                startA = startA.next;
                a--;
            }else{
                startB = startB.next;
                b--;
            }
        }
        
        while(startA != startB){
            startA = startA.next;
            startB = startB.next;
        }
        return startA;
    }
}