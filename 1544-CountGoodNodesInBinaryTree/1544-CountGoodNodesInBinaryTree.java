// Last updated: 8/28/2025, 9:52:54 PM
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
    public int goodNodes(TreeNode root) {
        return goodies(root,Integer.MIN_VALUE);
    }

    private int goodies(TreeNode node ,int curMax){
        if(node==null) return 0;

        int good=0;
        if(node.val>=curMax){
            good++;
            curMax=Math.max(curMax,node.val);
        }

        good+=goodies(node.left,curMax);
        good+=goodies(node.right,curMax);

        return good;
    }
}