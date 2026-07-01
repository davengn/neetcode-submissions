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
    public int goodNodes(TreeNode root) {
        int count = 0;
        if (root == null)
            return count;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<TreeNode, Integer>(root, root.val));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int max = pair.getValue();
            if (node.val >= max) {
                max = node.val;
                count++;
            }
            if (node.left != null) {
                stack.push(new Pair<TreeNode, Integer>(node.left, max));
            }
            if (node.right != null) {
                stack.push(new Pair<TreeNode, Integer>(node.right, max));
            }
        }
        return count;
    }
}
