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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode counterNode = head;
        ListNode reverserNode = head;
        ListNode endOfKGroup = null;
        int counter = 1;

        while(counterNode != null && counterNode.next != null){

            while(counter % k != 0 && counterNode.next != null){
                counterNode = counterNode.next;
                counter++;
            }
            if(endOfKGroup != null && counter % k == 0) endOfKGroup.next = counterNode;

            if(counter == k){
                head = counterNode; // reassign the head
            }

            if(counter % k == 0){
                counterNode = counterNode.next; // move to start of next cycle
                ListNode sentinelNode = counterNode;
                endOfKGroup = reverserNode;

                // reverserNode stuff
                while(reverserNode != counterNode){
                    ListNode nextNode = reverserNode.next;
                    ListNode prevNode = sentinelNode;
                    reverserNode.next = sentinelNode;
                    sentinelNode = reverserNode;
                    reverserNode = nextNode;
                }
            }
            counter++;
        }

        return head;
    }
}
