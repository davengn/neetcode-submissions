class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        for (int i = 0; i < n; i++) {
            int counter = 0;
            for (int j = i; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    counter = j - i;
                    break;
                }
            }
            temperatures[i] = counter;
        }
        return temperatures;
    }
}
