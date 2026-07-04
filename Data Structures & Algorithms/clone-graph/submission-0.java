/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> cache = new HashMap<>();
        queue.add(node);
        cache.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node nd = queue.poll();
            for (Node child : nd.neighbors) {
                if (!cache.containsKey(child)) {
                    Node newChild = new Node(child.val);
                    cache.put(child,newChild);
                    queue.add(child);
                }
                cache.get(nd).neighbors.add(cache.get(child));
            }
        }
        return cache.get(node);
    }
}