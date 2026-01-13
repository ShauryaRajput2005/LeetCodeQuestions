class Solution {
    class pair {
        int room;
        long endtime;

        pair(int room, long endtime) {
            this.room = room;
            this.endtime = endtime;
        }
    }

    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<pair> busy = new PriorityQueue<>(
                (a, b) -> {
                    if (a.endtime != b.endtime) {
                        return Long.compare(a.endtime, b.endtime);
                    }
                    return Integer.compare(a.room, b.room);
                });

        PriorityQueue<Integer> free = new PriorityQueue<>();

        int[] cnt = new int[n];
        int l = meetings.length;

        for (int i = 0; i < n; i++) {
            free.offer(i);
        }

        for (int i = 0; i < l; i++) {

            while (!busy.isEmpty() && busy.peek().endtime <= meetings[i][0]) {
                pair b = busy.poll();
                free.offer(b.room);
            }

            if (!free.isEmpty()) {
                int room = free.poll();
                busy.offer(new pair(room, meetings[i][1]));
                cnt[room]++;
            } else {
                pair early = busy.poll();
                int interval = meetings[i][1] - meetings[i][0];
                long end = early.endtime + interval;
                busy.offer(new pair(early.room, end));
                cnt[early.room]++;
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (cnt[i] > cnt[ans])
                ans = i;
        }
        return ans;
    }
}