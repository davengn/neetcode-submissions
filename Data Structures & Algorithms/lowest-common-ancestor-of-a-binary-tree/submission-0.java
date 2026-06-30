/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;
        Map<TreeNode, TreeNode> cache = new HashMap<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek();
                if (cur.right == null || cur.right == last) {
                    stack.pop();
                    TreeNode left = cache.getOrDefault(cur.left, null);
                    TreeNode right = cache.getOrDefault(cur.right, null);
                    if (cur.val == p.val || cur.val == q.val) {
                        cache.put(cur, cur);
                    } else {
                        if (left != null && right != null) {
                            cache.put(cur, cur);
                        } else if (left != null && right == null) {
                            cache.put(cur, left);
                        } else if (left == null && right != null) {
                            cache.put(cur, right);
                        }
                    }
                    last = cur;
                    cur = null;
                } else {
                    cur = cur.right;
                }
            }
        }
        return cache.get(root);
    }
}