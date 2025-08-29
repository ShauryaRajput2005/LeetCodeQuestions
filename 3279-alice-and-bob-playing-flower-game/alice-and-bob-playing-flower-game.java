class Solution {
    public long flowerGame(int n, int m) {
        long oddm=(m+1)/2;
        long evenm=m/2;
        long oddn=(n+1)/2;
        long evenn=n/2;
        return (oddm*evenn)+(oddn*evenm);

    }
}