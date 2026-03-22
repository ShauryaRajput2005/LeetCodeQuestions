class Solution {
    public boolean isAlienSorted(String[] words, String s) {
        int[] rank = new int[26];
        
        for (int i = 0; i < 26; i++) {
            rank[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int j = 0;

            while (j < Math.min(w1.length(), w2.length()) &&
                   w1.charAt(j) == w2.charAt(j)) {
                j++;
            }

            if (j < Math.min(w1.length(), w2.length())) {
                if (rank[w1.charAt(j) - 'a'] > rank[w2.charAt(j) - 'a']) {
                    return false;
                }
            }
            else {
                if (w1.length() > w2.length()) {
                    return false;
                }
            }
        }

        return true;
    }
}