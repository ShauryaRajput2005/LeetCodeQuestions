class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] used = new boolean[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        StringBuilder st = new StringBuilder();

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]--;

            if (used[idx])
                continue;

            while (st.length() > 0 &&
                   st.charAt(st.length() - 1) > c &&
                   freq[st.charAt(st.length() - 1) - 'a'] > 0) {

                used[st.charAt(st.length() - 1) - 'a'] = false;
                st.deleteCharAt(st.length() - 1);
            }

            st.append(c);
            used[idx] = true;
        }

        return st.toString();
    }
}