// Last updated: 8/28/2025, 9:53:10 PM
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
    int camera = 0;

    public int minCameraCover(TreeNode root) {
        if (cam(root) == -1) { // root itself needs coverage
            camera++;
        }
        return camera;
    }

    // Returns:
    // -1 : node needs coverage
    //  0 : node is covered
    //  1 : node has a camera
    public int cam(TreeNode root) {
        if (root == null) return 0; // null nodes are considered covered

        int left = cam(root.left);
        int right = cam(root.right);

        if (left == -1 || right == -1) {  // any child needs coverage
            camera++;
            return 1; // place camera here
        } else if (left == 1 || right == 1) { // any child has camera
            return 0; // current node is covered
        } else {
            return -1; // current node needs coverage
        }
    }
}
