class KthLargest {
    PriorityQueue<Integer> pq;
    int max = 0;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        max = k;
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.add(val);

        if (pq.size() > max) {
            pq.poll();
        }
        return pq.peek();
    }
}
