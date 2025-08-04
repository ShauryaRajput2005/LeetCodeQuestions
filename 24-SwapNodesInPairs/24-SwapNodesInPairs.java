// Last updated: 8/4/2025, 6:02:06 PM
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode prev = dum;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            // Swapping nodes
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev two nodes ahead
            prev = first;
        }

        return dum.next;
    }
}
