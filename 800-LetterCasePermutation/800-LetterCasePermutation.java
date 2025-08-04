// Last updated: 8/4/2025, 5:59:01 PM
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        permuts(s, 0, "", result);
        return result;
    }

    public static void permuts(String s, int index, String ans, List<String> result) {
        if (index == s.length()) {
            result.add(ans);
            return;
        }

        char cur = s.charAt(index);
        permuts(s, index + 1, ans + cur, result);
        if (Character.isLetter(cur)) {
            if (Character.isLowerCase(cur)) {
                permuts(s, index + 1, ans + Character.toUpperCase(cur), result);
            } else {
                permuts(s, index + 1, ans + Character.toLowerCase(cur), result);
            }
        }
    }
}