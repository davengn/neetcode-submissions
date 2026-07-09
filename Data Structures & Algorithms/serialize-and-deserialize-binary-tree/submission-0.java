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

public class Codec {
    private final String DELIMETER = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.append("N");
                res.append(DELIMETER);
                continue;
            }
            res.append(node.val);
            res.append(DELIMETER);
            queue.add(node.left);
            queue.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data ==null) return null;
        String[] raw = data.split(DELIMETER);
        TreeNode root = new TreeNode(Integer.parseInt(raw[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty() && index < raw.length) {
            TreeNode node = queue.poll();
            if(!raw[index].equals("N")){
                node.left = new TreeNode(Integer.parseInt(raw[index]));
                queue.add(node.left);
            }
            index++;
            if(!raw[index].equals("N")){
                node.right = new TreeNode(Integer.parseInt(raw[index]));
                queue.add(node.right);
            }
            index++;
        }
        return root;
    }
}
