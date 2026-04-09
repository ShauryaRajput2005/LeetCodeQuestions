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
    public void similarseuence(TreeNode root,List<Integer>list1 ){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
             list1.add(root.val);
        }
        similarseuence(root.left,list1);
        similarseuence(root.right,list1);
       
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      ArrayList<Integer> list1=new ArrayList<>();
      ArrayList<Integer> list2=new ArrayList<>();
        similarseuence(root1,list1);
        similarseuence(root2,list2);
        

        
         return list1.equals(list2);

      
    }
}