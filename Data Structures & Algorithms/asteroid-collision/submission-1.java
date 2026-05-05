class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            while (!stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0) {
                int diff = stack.peek() + asteroids[i];
                if (diff == 0) {
                    asteroids[i] = 0;
                    stack.pop();
                } else if (diff > 0) {
                    asteroids[i] = 0;
                } else {
                    stack.pop();
                }
            }
            if (asteroids[i] != 0) {
                stack.push(asteroids[i]);
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}