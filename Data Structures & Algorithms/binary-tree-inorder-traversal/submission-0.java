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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack  = new Stack<>();
        TreeNode current = root;
        while(current != null || stack.size() > 0){
            while(current !=null){
                stack.push(current);
                current = current.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            current=node.right;
        }
        return res;
    }
    
}