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
    public int diameterOfBinaryTree(TreeNode root) {
       int[] res = new int[1];
        dfs(root,res);
        return res[0];
       
    }
    private int dfs(TreeNode root,int[] res){
         if (root == null){
            return 0;
        }
        int maxL = 0;
        int maxR = 0;
        if (root.left != null) {
            maxL++;
            maxL = dfs(root.left,res);
        }
        if (root.right != null) {
            maxR++;
            maxR = dfs(root.right,res);
        }
        res[0] = Math.max(res[0],maxL + maxR);
        return 1+ Math.max(maxL,maxR);
    }
}
