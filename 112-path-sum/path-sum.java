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
    static class Pair{
        TreeNode node;
        int sum;
        Pair(TreeNode node, int sum){
            this.node=node;
            this.sum=sum;
        }
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Queue<Pair> q=new LinkedList<>();
        if(root==null) return false;
        q.offer(new Pair(root,root.val));
        while(!q.isEmpty()){
            Pair cur=q.poll();
            if(cur.sum==targetSum && cur.node.right==null && cur.node.left==null) return true;
            if(cur.node.right!=null) q.offer(new Pair(cur.node.right,cur.node.right.val+cur.sum));
            if(cur.node.left!=null) q.offer(new Pair(cur.node.left,cur.node.left.val+cur.sum));
        }

        return false;
    }
}