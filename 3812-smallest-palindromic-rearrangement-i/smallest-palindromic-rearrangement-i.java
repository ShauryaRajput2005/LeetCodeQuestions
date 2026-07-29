class Solution {
    public String smallestPalindrome(String s) {
        int[] cnt = new int[256];

        for (char c : s.toCharArray())
            cnt[c]++;

        StringBuilder left = new StringBuilder();
        char mid = 0;

        for (int i = 0; i < 256; i++) {
            if (cnt[i] % 2 == 1)
                mid = (char)i;

            for (int j = 0; j < cnt[i] / 2; j++)
                left.append((char)i);
        }

        StringBuilder ans = new StringBuilder(left);
        if (mid != 0)
            ans.append(mid);

        ans.append(left.reverse());

        return ans.toString();
    }
}