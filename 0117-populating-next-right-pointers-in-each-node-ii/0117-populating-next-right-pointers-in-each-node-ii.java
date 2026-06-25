/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
       if (root == null) return null;
        Deque<Node> dq=new ArrayDeque<>();
        dq.offer(root);
        while(!dq.isEmpty()){
            int size=dq.size();
            Node prev=null;
            while(size-->0){
                Node cur=dq.pollFirst();
                if (prev!=null){
                    prev.next=cur;
                }
                prev=cur;
                if(cur.left!=null) dq.offerLast(cur.left);
                if(cur.right!=null) dq.offerLast(cur.right);
                
            }
        }
        return root;
    }
}