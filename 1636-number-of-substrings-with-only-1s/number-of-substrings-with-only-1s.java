class Solution {
    public int numSub(String s) {
        long cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') continue;
            int left = i;
            int right = i;
            while (right < s.length() && s.charAt(right) == '1') right++;
            int l = right - left;
            cnt += (long) l * (l + 1) / 2;
            i = right - 1;
        }
        return (int)(cnt % 1000000007);
    }
}
