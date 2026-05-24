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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> ar=new ArrayList<>();
        while(head!=null){
            ar.add(head.val);
            head=head.next;
        }
        return build(ar,0,ar.size()-1);

    }
    public static TreeNode build(List<Integer> num,int left,int right){
        if(left>right) return null;
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(num.get(mid));
        root.left=build(num,left,mid-1);
        root.right=build(num,mid+1,right);
        return root;
    }
}