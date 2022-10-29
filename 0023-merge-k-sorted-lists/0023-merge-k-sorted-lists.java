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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<>(){
            @Override
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        for(ListNode l : lists){
            if(l != null)
                pq.offer(l);
        }
        ListNode head = new ListNode(-1);
        ListNode ptr = head;
        while(!pq.isEmpty()){
            ListNode l = pq.poll();
            ptr.next = l;
            ptr = ptr.next;
            if(l.next != null)
                pq.offer(l.next);
            
        }
        return head.next;
    }
}