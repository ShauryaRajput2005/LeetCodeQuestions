class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        calc(numRows, 0, 0, 1, result, ans);
        return result;

    }

    public static void calc(int r, int row, int col, int ncr, List<List<Integer>> result, List<Integer> ans) {
        if (row == r) {
            return;
        }
        if (col > row) {
            result.add(new ArrayList<>(ans));
            calc(r, row + 1, 0, 1, result,new ArrayList<>());
            return;
        }
        ans.add(ncr);
        int nextNcr = ncr * (row - col) / (col + 1);
        calc(r, row, col + 1, nextNcr, result,ans);

    }
}