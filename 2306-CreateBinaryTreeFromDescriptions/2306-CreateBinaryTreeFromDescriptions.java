// Last updated: 8/28/2025, 9:52:08 PM
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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> map=new HashMap<>();
        Set<Integer> children=  new HashSet<>();

        for(int[] d:descriptions){
            int parentval=d[0] ,childval=d[1],isleft=d[2];

            map.putIfAbsent(parentval,new TreeNode(parentval));
            map.putIfAbsent(childval,new TreeNode(childval));
            
            TreeNode parent=map.get(parentval);
            TreeNode child=map.get(childval);

            if(isleft==1) parent.left=child;
            else parent.right=child;

            children.add(childval);
        }        
         for (int[] d : descriptions) {
            if (!children.contains(d[0])) {
                return map.get(d[0]);
            }
        }
        return null;

    }
}