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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root ==null) return false;
        Stack < Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, targetSum - root.val)) ;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> nodePair = stack.pop();
            TreeNode node = nodePair.getKey();
            int curSum = nodePair.getValue();
            if (node.left == null && node.right == null && curSum == 0) {
                return true;
            }
            if(node.right !=null){
                stack.push(new Pair<>(node.right,curSum - node.right.val));
            }
            if(node.left !=null){
                stack.push(new Pair<>(node.left,curSum - node.left.val));
            }
        }
        return false;
    
    }
}