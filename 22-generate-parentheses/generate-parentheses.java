class Solution {
    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        para(n, 0, 0, new StringBuilder());
        return result;
    }

    public void para(int n, int open, int close, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            para(n, open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            para(n, open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}