class Solution {
    static ArrayList<TreeNode> pre;

    public void flatten(TreeNode root) {
        if(root == null) return;

        pre = new ArrayList<>();
        preOrder(root);

        for(int i = 0; i < pre.size() - 1; i++){
            pre.get(i).left = null;
            pre.get(i).right = pre.get(i + 1);
        }

        TreeNode last = pre.get(pre.size() - 1);
        last.left = null;
        last.right = null;
    }

    public static void preOrder(TreeNode root){
        if(root == null) return;

        pre.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}