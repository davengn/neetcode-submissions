/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if(node.left != null && node.right !=null){
                node.left.next = node.right;
            }
            if(node.next !=null && node.next.right !=null){
                node.right.next = node.next.left;
            }
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left !=null){
                stack.push(node.left);
            }
        }
        return root;
    }
}