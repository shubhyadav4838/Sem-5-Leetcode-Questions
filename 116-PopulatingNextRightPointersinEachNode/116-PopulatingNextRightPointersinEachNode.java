// Last updated: 11/8/2025, 8:23:04 pm
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
        if (root == null) {
            return root;
        }
        Node ans = root;
        Queue<Node> queue = new LinkedList<>();
        Node currentNode = root;
        queue.offer(root);
        int levelsize = 0;
        while(!queue.isEmpty()){
            levelsize = queue.size();
            for(int i = 0 ; i < levelsize ; i++ ){
                currentNode = queue.poll();
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!= null){
                    queue.offer(currentNode.right);
                }
                if(i < levelsize -1){
                    currentNode.next = queue.peek();
                }
            }
            currentNode.next = null;
        }
        return ans;
    }
}