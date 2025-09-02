class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int g : gifts) pq.add(g);
        
        while (k-- > 0) {
            int top = pq.poll();
            pq.add((int) Math.floor(Math.sqrt(top)));
        }
        
        long sum = 0;
        while (!pq.isEmpty()) sum += pq.poll();
        return sum;
    }
}
