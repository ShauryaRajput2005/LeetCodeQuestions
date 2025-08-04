// Last updated: 8/4/2025, 6:00:33 PM
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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    public void dfs(TreeNode root, int level, List<Integer> res) {
        if (root == null) return;

        if (level == res.size()) {
            res.add(root.val);  // First node at this level
        }

        dfs(root.right, level + 1, res); // Right first
        dfs(root.left, level + 1, res);  // Then left
    }
}
