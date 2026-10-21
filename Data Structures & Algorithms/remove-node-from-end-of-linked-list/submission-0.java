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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode pass = head;
        int count = 1;
        while(pass.next != null){
            pass = pass.next;
            count++;
        }

        int index = count - n;
        if(index == 0) return head.next;

        int count2 = 0;
        pass = head;
        while(pass.next != null){
            ListNode pass2 = pass;
            pass = pass.next;
            count2++;
            if(count2 == index){
                pass2.next = pass.next;
                return head;
            }
        }
        return head;
    }
}
