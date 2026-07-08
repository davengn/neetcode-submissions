class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> path = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int course) {
        if (path.contains(course)) {
            return false;
        }
        if (graph.get(course).isEmpty()) {
            return true;
        }
        path.add(course);
        List<Integer> neighbors = graph.get(course);
        graph.replace(course, new ArrayList<>());
        for (Integer nei : neighbors) {
            if (!dfs(nei)) {
                return false;
            }
        }
        path.remove(course);
        return true;
    }
}
