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
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        int target = size - n;
        int i = 0;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode current = node;
        while (current.next != null) {
            if (i == target) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
            i++;
        }
         head = node.next;
         return head;
    }
}