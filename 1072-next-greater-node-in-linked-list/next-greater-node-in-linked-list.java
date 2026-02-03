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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ll = new ArrayList<>();
        ListNode node = head;
        while(node!=null) {
            ll.add(node.val);
            node = node.next;
        }
        int[] res = new int[ll.size()];
        Stack<Integer> sk = new Stack<>();
        for(int i = 0;i<ll.size();i++){
            while(!sk.isEmpty() && ll.get(sk.peek())<ll.get(i)){
                res[sk.pop()] = ll.get(i);
            }
            sk.push(i);
        }
        return res;
    }
}