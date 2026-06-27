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
    public boolean isBalanced(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode,Integer> depths = new HashMap<>();
        TreeNode cur = root , last = null;
        while(cur !=null || !stack.isEmpty()){
            if(cur !=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.peek();
                if(cur.right == null || last == cur.right){
                    stack.pop();
                    int left = depths.getOrDefault(cur.left,0);
                    int right = depths.getOrDefault(cur.right,0);
                    if(Math.abs(left - right) > 1){
                        return false;
                    }
                    last = cur;
                    depths.put(cur,1 + Math.max(left,right));
                    cur = null;
                }else{
                    cur = cur.right;
                }
            }
        }
        return true;
    }
}
