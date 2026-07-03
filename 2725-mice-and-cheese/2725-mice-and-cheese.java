class Solution {
    static class Pair {
        int diff;
        int idx;

        Pair(int diff, int idx) {
            this.diff = diff;
            this.idx = idx;
        }
    }

    public int miceAndCheese(int[] m1, int[] m2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.diff - a.diff);
        int n = m1.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(m1[i] - m2[i], i));
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            Pair p = pq.poll();
            sum += m1[p.idx];
        }
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            sum += m2[p.idx];
        }
        return sum;

    }
}