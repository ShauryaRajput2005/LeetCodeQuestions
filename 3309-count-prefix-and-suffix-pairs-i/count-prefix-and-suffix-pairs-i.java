class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int cnt = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isPrefixAndSuffix(words[j], words[i])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static boolean isPrefixAndSuffix(String w1, String w2) {
        return w2.startsWith(w1) && w2.endsWith(w1);
    }
}