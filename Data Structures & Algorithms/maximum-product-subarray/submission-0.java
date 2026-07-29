class Solution {
    public int maxProduct(int[] nums) {
        List<List<Integer>> segments = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int res = Integer.MIN_VALUE;

        for (int n : nums) {
            res = Math.max(res, n);
            if (n == 0) {
                if (!cur.isEmpty())
                    segments.add(cur);
                cur = new ArrayList<>();
                continue;
            }
            cur.add(n);
        }
        if (!cur.isEmpty())
            segments.add(cur);

        for (List<Integer> seg : segments) {
            int negs = 0;
            for (int n : seg) {
                if (n < 0) {
                    negs++;
                }
            }
            int need = (negs % 2) == 0 ? negs : negs - 1;
            negs = 0;
            int prod = 1;
            for (int i = 0, j = 0; i < seg.size(); i++) {
                prod *= seg.get(i);
                if (seg.get(i) < 0) {
                    negs++;
                    while (negs > need) {
                        prod /= seg.get(j);
                        if (seg.get(j) < 0)
                            negs--;

                        j++;
                    }
                }

                if (j <= i) {
                    res = Math.max(res, prod);
                }
            }
        }
        return res;
    }
}
