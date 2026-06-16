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
    public void reorderList(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            arr.add(node.val);
            node = node.next;
        }

        int left = 0;
        int right = arr.size() - 1;
        node = head;

        while (left <= right) {
            if (left == right) {
                node.val = arr.get(left);
                break;
            }

            node.val = arr.get(left);
            node = node.next;
            left++;

            node.val = arr.get(right);
            node = node.next;
            right--;
        }
    }
}
