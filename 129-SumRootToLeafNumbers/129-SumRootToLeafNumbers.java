// Last updated: 8/4/2025, 6:01:01 PM
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
    public int sumNumbers(TreeNode root) {
        return numbers(root,0);
        
    }

    public static int numbers(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right ==null){
            return sum *10+root.val;
        }

        int left=numbers(root.left,sum*10+root.val);
        int right=numbers(root.right,sum*10+root.val);

        return left+right;
    }
}