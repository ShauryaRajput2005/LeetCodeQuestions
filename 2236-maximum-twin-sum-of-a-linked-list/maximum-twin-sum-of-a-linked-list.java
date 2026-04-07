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
    public int pairSum(ListNode head) {
        if(head==null) return 0;
        if (head.next==null )return head.val;
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        ListNode temp=head;
        while(temp!=null){
            dq.offerLast(temp.val);
            temp=temp.next;
        }
        int max=0;
        while(!dq.isEmpty()){
            int a=dq.pollFirst();
            int b=dq.pollLast();
            max=Math.max(a+b,max);
        }
        return max;
    }
}