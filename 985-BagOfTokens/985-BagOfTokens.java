// Last updated: 8/4/2025, 5:58:44 PM
import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int max = 0;
        int end = tokens.length - 1;
        int start = 0;

        while (start <= end) {
            if (power >= tokens[start]) {
                score++;
                power -= tokens[start++];
                max = Math.max(max, score);
            } else if (score > 0) {
                score--;
                power += tokens[end--];
            } else {
                break;
            }
        }

        return max;
    }
}
