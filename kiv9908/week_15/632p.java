class Solution {
    static int[] memo;
    
    public int solution(int n) {
        memo = new int[n + 1];
        memo[0] = 0; 
        memo[1] = 1; 
        
        return fibo(n);
    }
    
    private static int fibo(int n) {
        if (memo[n] != 0 || n == 0) { 
            return memo[n];
        }
        
        memo[n] = (fibo(n - 1) + fibo(n - 2))% 1234567;
        return memo[n];
    }
}
