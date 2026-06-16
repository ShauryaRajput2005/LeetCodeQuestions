/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> q=new LinkedList();
        q.offer(cloned);
        
        while(!q.isEmpty()){
            TreeNode p=q.poll();
            if(target.val==p.val) return p;
            if(p.left!=null) q.offer(p.left);
            if(p.right!=null) q.offer(p.right);
        }
        return null;
    }
}