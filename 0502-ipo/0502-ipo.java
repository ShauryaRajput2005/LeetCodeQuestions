import java.util.PriorityQueue;

class Solution {
    class Pair {
        int cap;
        int pro;
        Pair(int cap, int pro) {
            this.cap = cap;
            this.pro = pro;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        
        PriorityQueue<Pair> minCapitalPQ = new PriorityQueue<>((a, b) -> Integer.compare(a.cap, b.cap));
        for (int i = 0; i < n; i++) {
            minCapitalPQ.offer(new Pair(capital[i], profits[i]));
        }

        PriorityQueue<Pair> maxProfitPQ = new PriorityQueue<>((a, b) -> Integer.compare(b.pro, a.pro));
        
        while (k > 0) {
           
            while (!minCapitalPQ.isEmpty() && minCapitalPQ.peek().cap <= w) {
                maxProfitPQ.offer(minCapitalPQ.poll());
            }
            if (maxProfitPQ.isEmpty()) {
                break;
            }
           
            w += maxProfitPQ.poll().pro;
            k--;
        }
        
        return w;
    }
}
