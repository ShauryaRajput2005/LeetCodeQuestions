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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans =new ArrayList<>();
        Queue<TreeNode> q=new LinkedList();
        if(root==null) return ans;
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> lev=new ArrayList<>();
            while(size-->0){
                TreeNode cur=q.poll();
                lev.add(cur.val);
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            ans.add(0,lev);
        }

        return ans;
    }
}