class Solution {

    public int sumRootToLeaf(TreeNode root) {
        return conv(root, 0);
    }

    public int conv(TreeNode root, int num) {
        if (root == null) return 0;

        num = (num << 1) | root.val;

        if (root.left == null && root.right == null) {
            return num;
        }

        return conv(root.left, num) + conv(root.right, num);
    }
}