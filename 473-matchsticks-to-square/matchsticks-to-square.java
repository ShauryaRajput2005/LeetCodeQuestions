class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0)
            return false;
        int side = sum / 4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] sides = new int[4];
        return dfs(matchsticks, 0, sides, side);

    }

    public static boolean dfs(int[] match, int idx, int[] sides, int s) {
        if (idx == match.length) {
            return sides[0] == s && sides[1] == s && sides[2] == s && sides[3] == s;
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + match[idx] <= s) {
                sides[i]+= match[idx];
                if (dfs(match, idx + 1, sides, s)) return true;
                sides[i] -= match[idx];
            }
        }
        return false;
    }

    private void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}