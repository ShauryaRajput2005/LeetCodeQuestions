// Last updated: 8/4/2025, 6:01:11 PM
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head); // Dummy before head
        ListNode prev = dummy;
        
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                int dupVal = head.val;
                while (head != null && head.val == dupVal) {
                    head = head.next; // Skip all duplicates
                }
                prev.next = head; 
                
            } else {
                prev = prev.next;
                head = head.next;
            }
        }
        
        return dummy.next;
    }
}
