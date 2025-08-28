// Last updated: 8/28/2025, 9:53:06 PM
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll(); 
            if (y != x) pq.offer(y - x); 
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}
