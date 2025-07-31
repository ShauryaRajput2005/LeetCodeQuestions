// Last updated: 7/31/2025, 10:34:41 PM
class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int m=prices[0]+prices[1];
        if(m>money) return money;
        return money-m;
    }
}