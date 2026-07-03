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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<TreeNode, Integer>(root, 1));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int level = pair.getValue();
            if (res.size() < level) {
                res.add(new ArrayList<Integer>());
            }
            res.get(level - 1).add(node.val);
            if (node.left != null) {
                queue.add(new Pair<TreeNode, Integer>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new Pair<TreeNode, Integer>(node.right, level + 1));
            }
        }
        return res;
    }
}
