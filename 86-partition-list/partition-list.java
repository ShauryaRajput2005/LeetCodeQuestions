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
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(0);
        ListNode large=new ListNode(0);
        
        ListNode l=large;
        ListNode s=small;


        ListNode dum=head;
        while(head!=null){
            if(head.val<x){
                s.next=new ListNode(head.val);
                s=s.next;
            }else{
                l.next=new ListNode(head.val);
                l=l.next;
            }
            head=head.next;

        }
        s.next=large.next;
        return small.next;
    }
}