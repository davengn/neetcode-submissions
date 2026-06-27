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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                if(sameTree(cur, subRoot)){
                     return true;
                }
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                cur = cur.left;
            } else {
                cur = stack.pop();
            }
        }
        return false;
    }
    private boolean sameTree(TreeNode t1, TreeNode t2) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode node1 = nodes[0];
            TreeNode node2 = nodes[1];
            if (node1 == null && node2 == null)
                continue;
            else if (node1 == null || node2 == null || node1.val != node2.val)
                return false;
            stack.push(new TreeNode[] {node1.right, node2.right});
            stack.push(new TreeNode[] {node1.left, node2.left});
        }
        return true;
    }
}
