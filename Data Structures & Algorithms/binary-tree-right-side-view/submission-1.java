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
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return res;
        Stack<Pair<TreeNode,Integer>> stack = new Stack<>();
        stack.push(new Pair<TreeNode,Integer>(root,0));
        int maxDepth = -1;
        while(!stack.isEmpty()){
            Pair<TreeNode,Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int depth =  pair.getValue();
            if(depth > maxDepth){
                res.add(node.val);
                maxDepth = depth;
            }
            if(node.left !=null){
                stack.push(new Pair<TreeNode,Integer>(node.left,depth +1));
            }
            if(node.right !=null){
                stack.push(new Pair<TreeNode,Integer>(node.right,depth +1));
            }
        }
        return res;
    }
}
