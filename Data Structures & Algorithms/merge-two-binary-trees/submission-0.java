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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2; // edge case
        if (root2 == null)
            return root1; // edge case
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] {root1, root2});
        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode node1 = nodes[0];
            TreeNode node2 = nodes[1];
            if (node2 == null) {
                continue;
            }
            node1.val += node2.val;
            if (node1.left == null) {
                node1.left = node2.left;
            } else {
                stack.push(new TreeNode[] {node1.left, node2.left});
            }

            if (node1.right == null) {
                node1.right = node2.right;
            } else {
                stack.push(new TreeNode[] {node1.right, node2.right});
            }
        }
        return root1;
    }
}