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
        List<Integer> arr = new ArrayList<>();
        ListNode node = head;
        while(node !=null){
            arr.add(node.val);
            node = node.next;
        }
        arr.remove(arr.size()  - n);
        if(arr.isEmpty()) return null;
        ListNode result = new ListNode(arr.get(0));
        ListNode current = result;
        for(int i = 1; i< arr.size();i++){
            current.next = new ListNode(arr.get(i));
            current = current.next;
        }
        return result;
    }
}
