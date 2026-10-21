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
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node head2 = head;
        while(head2 != null){
            map.put(head2, new Node(head2.val));
            head2 = head2.next;
        }

        Node output = map.get(head);
        Node secondPass = output;
        while(secondPass != null){
            secondPass.next = map.get(head.next);
            secondPass.random = map.get(head.random);
            secondPass = secondPass.next;
            head = head.next;
        }
        return output;
    }
}
