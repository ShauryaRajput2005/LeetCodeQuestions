class Solution {
    public int strStr(String h, String n) {
        int m = n.length(), i = 0, j = 0;
        if (m == 0) return 0;

        int[] lps = new int[m];
        for (int k = 1, len = 0; k < m; ) {
            if (n.charAt(k) == n.charAt(len)) lps[k++] = ++len;
            else if (len > 0) len = lps[len - 1];
            else k++;
        }

        while (i < h.length()) {
            if (h.charAt(i) == n.charAt(j)) {
                i++; j++;
                if (j == m) return i - m;
            } else if (j > 0) j = lps[j - 1];
            else i++;
        }
        return -1;
    }
}