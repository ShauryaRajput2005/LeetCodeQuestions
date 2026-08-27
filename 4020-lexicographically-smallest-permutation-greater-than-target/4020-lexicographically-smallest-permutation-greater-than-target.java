
class Solution {

    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        char[] ans = new char[n];

        int i = 0;

        while (i < n && freq[target.charAt(i) - 'a'] > 0) {
            char ch = target.charAt(i);
            ans[i] = ch;
            freq[ch - 'a']--;
            i++;
        }

        while (i >= 0) {

            if (i < n) {
                for (int c = target.charAt(i) - 'a' + 1; c < 26; c++) {

                    if (freq[c] > 0) {

                        ans[i] = (char) ('a' + c);
                        freq[c]--;

                        int index = i + 1;

                        for (int ch = 0; ch < 26; ch++) {
                            while (freq[ch] > 0) {
                                ans[index++] = (char) ('a' + ch);
                                freq[ch]--;
                            }
                        }

                        return new String(ans);
                    }
                }
            }

            if (i == 0) {
                break;
            }

            i--;
            freq[ans[i] - 'a']++;
        }

        return "";
    }
}