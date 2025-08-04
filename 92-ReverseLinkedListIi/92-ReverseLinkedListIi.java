// Last updated: 8/4/2025, 6:01:08 PM
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left==right) return head;

        ListNode dum=new ListNode(0);
        dum.next=head;
        ListNode prev=dum;

        for(int i=1;i<left;i++){
            prev=prev.next;
        }

        ListNode start=prev.next;
        ListNode then=start.next;

        for(int i=0;i<right-left;i++){
            start.next = then.next;    // detach `then`
            then.next = prev.next;     // insert `then` at the beginning of reversed part
            prev.next = then;          // reconnect
            then = start.next;
        }
        return dum.next;
        
    }
}