class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] ans = new int[n];
        Deque<Integer> dq=new ArrayDeque<>();
        Arrays.sort(deck);
        dq.offerFirst(deck[n-1]); 
        for(int i=n-2;i>=0;i--){
            int l=dq.pollLast();
            dq.offerFirst(l);
            dq.offerFirst(deck[i]);
        }
        int idx = 0;
        for (int x : dq) {
            ans[idx++] = x;
        }

        return ans;
    }
}