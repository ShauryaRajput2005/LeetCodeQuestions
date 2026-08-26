class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int curOnes = 0;
        String ans = "";

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') {
                curOnes++;
            }

            // Shrink from the left as long as we have valid conditions
            while (curOnes == k) {
                // Trim leading zeros to make the current window as small as possible
                while (s.charAt(left) == '0') {
                    left++;
                }

                int currentLength = right - left + 1;
                String currentStr = s.substring(left, right + 1);

                // Update if it's strictly shorter OR same length but lexicographically smaller
                if (currentLength < minLength) {
                    minLength = currentLength;
                    ans = currentStr;
                } else if (currentLength == minLength) {
                    if (ans.isEmpty() || currentStr.compareTo(ans) < 0) {
                        ans = currentStr;
                    }
                }

                // Move left pointer forward to look for other windows
                if (s.charAt(left) == '1') {
                    curOnes--;
                }
                left++;
            }
        }
        return ans;
    }
}
