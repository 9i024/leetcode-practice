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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        ListNode l1pass = l1;
        ListNode l2pass = l2;
        int carryover = 0;

        while(l1pass != null && l2pass != null){
            curr.next = new ListNode();
            curr = curr.next;
            int total = l1pass.val + l2pass.val;
            curr.val = (total + carryover) % 10;
            carryover = (total + carryover - curr.val) / 10;
            l1pass = l1pass.next;
            l2pass = l2pass.next;
        }

        while(l1pass != null){
            curr.next = new ListNode();
            curr = curr.next;
            curr.val = (l1pass.val + carryover) % 10;
            carryover = (l1pass.val + carryover - curr.val) / 10;
            l1pass = l1pass.next;
        }

        while(l2pass != null){
            curr.next = new ListNode();
            curr = curr.next;
            curr.val = (l2pass.val + carryover) % 10;
            carryover = (l2pass.val + carryover - curr.val) / 10;
            l2pass = l2pass.next;
        }

        if(l1pass == null && l2pass == null && carryover > 0) curr.next = new ListNode(carryover);

        return head.next;
    }
}
