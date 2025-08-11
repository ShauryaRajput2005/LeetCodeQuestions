class Solution {
    public int[] productQueries(int n, int[][] queries) {
        long mod = 1000000007;
        String binary = Integer.toBinaryString(n);
        ArrayList<Long> powers=new ArrayList<>();
        int blen=binary.length();
        for (int i = 0; i < blen; i++) {
            if (binary.charAt(blen - 1 - i) == '1') {
                powers.add(1L << i);
            }
        }

        int len = queries.length;
        int ans[] = new int[len];
         for (int q = 0; q < len; q++) {
            int left = queries[q][0];
            int right = queries[q][1];
            long product = 1;
            for (int i = left; i <= right; i++) {
                product = (product * powers.get(i)) % mod;
            }
            ans[q] = (int) product;
        }
        return ans;
    }
}