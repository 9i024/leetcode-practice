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
        if(head == null || k <= 1) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode kth = dummy;
        ListNode curr = head;
        ListNode kGroupLinker = dummy;

        while(true){
            
            for(int i = 0; i < k && kth != null; i++){
                kth = kth.next;
            }
            if(kth == null) break;

            ListNode prev = kth.next;
            ListNode endOfKGroup = curr;
            ListNode stopNode = kth.next;

            while(curr != stopNode){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            kGroupLinker.next = kth;
            kGroupLinker = endOfKGroup;
            kth = endOfKGroup;
        }
        return dummy.next;
    }
}
