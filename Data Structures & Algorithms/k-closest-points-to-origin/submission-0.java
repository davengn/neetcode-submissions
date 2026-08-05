class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(distB, distA); // Max-heap order
        });
        int[][] res = new int[k][2];
        for (int[] p : points) {
            pq.offer(p);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int index = 0;
        while(!pq.isEmpty() && index < k){
            res[index] = pq.poll();
            index++;
        }
        return res;
    }
}
