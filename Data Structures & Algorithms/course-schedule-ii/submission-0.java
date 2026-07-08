class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> path = new HashSet<>();
    Set<Integer> visit = new HashSet<>();
    List<Integer> output = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int[] pair : prerequisites) {
            graph.computeIfAbsent(pair[0],
                k -> new ArrayList<>()).add(pair[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        for(int i =0; i < result.length ; i++){
            result[i] = output.get(i);
        }
        return result;
    }
    private boolean dfs(int course) {
        if (path.contains(course)) {
            return false;
        }
        if (visit.contains(course)) {
            return true;
        }
    
        path.add(course);
        List<Integer> neighbors = graph.getOrDefault(course,Collections.emptyList());
        for (Integer nei : neighbors) {
            if (!dfs(nei)) {
                return false;
            }
        }
        output.add(course);
        visit.add(course);
        path.remove(course);
        return true;
    }
}
