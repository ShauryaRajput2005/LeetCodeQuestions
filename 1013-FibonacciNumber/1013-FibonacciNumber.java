// Last updated: 8/4/2025, 5:58:42 PM
class Solution {
    public int fib(int n) {
        return fibonacci(n);
    }
    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        int f1=fibonacci(n-1);
        int f2=fibonacci(n-2);
        return f1+f2;
    }
}