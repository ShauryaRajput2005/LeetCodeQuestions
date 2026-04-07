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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int di=b-a;
        ListNode slow=list1;
        ListNode fast=list1;
        for(int i=0;i<di;i++){
            fast=fast.next;
        }
        ListNode prev=null;
        for(int i=0;i<a;i++){
            prev=slow;
            slow=slow.next;
            fast=fast.next;
        }
        prev.next=list2;
        while(prev.next!=null){
            prev=prev.next;
        }
        prev.next=fast.next;
        return list1;
    }
}