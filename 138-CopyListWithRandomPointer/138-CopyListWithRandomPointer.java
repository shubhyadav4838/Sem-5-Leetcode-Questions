// Last updated: 4/8/2025, 12:00:11 am
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    private Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null)return null;
        if(map.containsKey(head)){
            return map.get(head);
        }
        Node dummy = new Node(head.val);
        map.put(head,dummy);
        dummy.next = copyRandomList(head.next);
        dummy.random = copyRandomList(head.random);
        return dummy;
    }
}