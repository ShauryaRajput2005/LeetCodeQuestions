class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean left = true;

        while(!q.isEmpty()){
            int size=q.size();
            LinkedList<Integer> level = new LinkedList<>();

            while(size-->0){
                TreeNode cur=q.poll();
                if(left) level.addLast(cur.val);
                else level.addFirst(cur.val);
                
                if(cur.left!=null) q.offer(cur.left); 
                if(cur.right!=null) q.offer(cur.right); 
            }
            ans.add(level);
            left=!left;
        }

        return ans;
    }
}