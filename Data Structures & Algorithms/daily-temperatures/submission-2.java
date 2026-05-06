class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int[] last = stack.peek();
                result[last[1]] = i - last[1];
                stack.pop();
            }
            stack.push(new int[]{temperatures[i],i});
        }
        return result;
    }
}
