/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if(root !=null) stack.push(root);
        while (stack.size() > 0) {
            Node node = stack.pop();
            res.add(node.val);
            List<Node> childs = node.children;
            for (int i = 0; i < childs.size(); i++) {
                stack.push(childs.get(i));
            }
        }
        Collections.reverse(res);
        return res;
    }
}