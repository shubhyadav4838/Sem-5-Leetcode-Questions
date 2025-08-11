// Last updated: 11/8/2025, 8:22:09 pm
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
        if(root==null)return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Node nn = q.poll();
                if(size!=0){
                    nn.next = q.peek();
                }
                if(nn.left!=null){
                    q.add(nn.left);
                }
                if(nn.right!=null){
                    q.add(nn.right);
                }
            }
        }
        return root;       
    }
}