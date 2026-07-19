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
    static List<String> result;

    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList();
        if (root == null)
            return result;
        StringBuilder ans = new StringBuilder();
        path(root, ans);
        return result;
    }

    public void path(TreeNode root, StringBuilder ans) {
        int n=ans.length();
        ans.append(root.val);
        if (root.left == null && root.right == null){
            result.add(ans.toString());
        }else{
            ans.append("->");
            if (root.left != null) path(root.left, ans);
            if (root.right != null) path(root.right, ans);
        }

        ans.setLength(n);
    }
}