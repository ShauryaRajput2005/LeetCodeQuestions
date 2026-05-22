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
    static int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum=0;
        summer(root,false);
        return sum;
    }
    public static void summer(TreeNode root,boolean side){
        if(root==null) return;
        if(root.left==null && root.right==null && side){
            sum+=root.val;
        }
        summer(root.left,true);
        summer(root.right,false);
    }
}