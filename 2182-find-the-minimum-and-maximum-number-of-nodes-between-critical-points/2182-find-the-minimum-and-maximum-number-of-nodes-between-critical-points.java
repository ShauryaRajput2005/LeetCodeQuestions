class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return new int[]{-1, -1};

        ListNode prev = head;
        head = head.next;

        int first = -1, last = -1;
        int min = Integer.MAX_VALUE;
        int idx = 1;

        while (head.next != null) {
            ListNode cur = head;

            if ((prev.val < cur.val && cur.val > head.next.val) ||
                (prev.val > cur.val && cur.val < head.next.val)) {

                if (first == -1) {
                    first = idx;
                } else {
                    min = Math.min(min, idx - last);
                }
                last = idx;
            }

            prev = cur;
            head = head.next;
            idx++;
        }

        if (first == last) return new int[]{-1, -1};

        return new int[]{min, last - first};
    }
}