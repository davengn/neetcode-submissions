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
    public int sumNumbers(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<TreeNode, Integer>(root, 0));
        int sum = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int pathSum = pair.getValue();

          
            pathSum = pathSum * 10 + node.val;
            if (node.left == null && node.right == null) {
                sum += pathSum;
            }
            if (node.left != null) {
                stack.push(new Pair<TreeNode, Integer>(node.left, pathSum));
            }
            if (node.right != null) {
                stack.push(new Pair<TreeNode, Integer>(node.right, pathSum));
            }
        }
        return sum;
    }
}