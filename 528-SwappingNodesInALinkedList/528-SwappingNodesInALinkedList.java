// Last updated: 8/4/2025, 5:59:29 PM
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        // Step 1: Find the k-th node from the beginning
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode temp = head;
        ListNode second = head;
        // Step 2: Move `temp` to the k-th position
        for (int i = 1; i < k; i++) {
            temp = temp.next;
        }

        // Step 3: Now move `temp` to the end and move `second` simultaneously
        while (temp.next != null) {
            temp = temp.next;
            second = second.next;
        }

        // Step 4: Swap values
        int t = first.val;
        first.val = second.val;
        second.val = t;

        return head;
    }
}
