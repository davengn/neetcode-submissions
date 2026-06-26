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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || stack.size() > 0) {
            while (cur != null) {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (!stack.isEmpty() && cur.right != null && stack.peek() == cur.right) {
                stack.pop();
                stack.push(cur);
                cur = cur.right;
            }else{
                res.add(cur.val);
                cur = null;
            }
        }
        return res;
    }
}