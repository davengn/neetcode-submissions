/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return false;
        Stack<Object[]> stack = new Stack<>();
        stack.push(new Object[] {root, null, null});
        while (!stack.isEmpty()) {
            Object[] obj = stack.pop();
            TreeNode node = (TreeNode) obj[0];
            Long lower = (Long) obj[1];
            Long upper = (Long) obj[2];
            if (node == null)
                continue;
            if (lower != null && node.val <= lower) {
                return false;
            }
            if (upper != null && node.val >= upper) {
                return false;
            }
            stack.push(new Object[]{node.left, lower, (long) node.val});
            stack.push(new Object[]{node.right, (long) node.val, upper});
        }
        return true;
    }
}
