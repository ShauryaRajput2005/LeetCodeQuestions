class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Double.compare(gain(b),gain(a)));

        for(int[] c:classes){
            pq.add(c);
        }
        while(extraStudents-->0){
            int[] c=pq.poll();
            c[0]+=1;
            c[1]+=1;
            pq.add(c);
        }

        double sum=0.0;
        for(int[] i :pq){
            sum+=(double) i[0]/i[1];
        }

    return sum/classes.length;

    }

    private double gain(int[] c) {
        int p = c[0], t = c[1];
        return (double) (p + 1) / (t + 1) - (double) p / t;
    }
}