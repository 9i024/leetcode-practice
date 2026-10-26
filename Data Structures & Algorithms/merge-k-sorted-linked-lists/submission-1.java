/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        ListNode head = new ListNode(0, null);
        ListNode curr = head;

        for(ListNode node : lists){
            if(node != null){
                minHeap.add(node);
            }
        }

        while(!minHeap.isEmpty()){
            curr.next = minHeap.poll();
            curr = curr.next;
            if(curr.next != null) minHeap.add(curr.next);
        }

        return head.next;
    }
}
