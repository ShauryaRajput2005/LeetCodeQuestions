class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;

        List<Integer> mod1 = new ArrayList<>();
        List<Integer> mod2 = new ArrayList<>();

        for (int x : nums) {
            sum += x;
            if (x % 3 == 1) mod1.add(x);
            else if (x % 3 == 2) mod2.add(x);
        }

        // Sort small groups only
        Collections.sort(mod1);
        Collections.sort(mod2);

        if (sum % 3 == 0) return sum;

        int ans = 0;

        if (sum % 3 == 1) {
            int option1 = mod1.size() >= 1 ? mod1.get(0) : Integer.MAX_VALUE;
            int option2 = mod2.size() >= 2 ? mod2.get(0) + mod2.get(1) : Integer.MAX_VALUE;
            ans = sum - Math.min(option1, option2);
        } else { // sum % 3 == 2
            int option1 = mod2.size() >= 1 ? mod2.get(0) : Integer.MAX_VALUE;
            int option2 = mod1.size() >= 2 ? mod1.get(0) + mod1.get(1) : Integer.MAX_VALUE;
            ans = sum - Math.min(option1, option2);
        }

        return ans < 0 ? 0 : ans;
    }
}
