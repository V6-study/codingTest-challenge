class Solution {
    static int[] memo;
    public int solution(int n) {
        memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 2;
        return cal(n);
    }
    private static int cal(int n){
        if(memo[n] != 0){
            return memo[n];
        }
        memo[n] = (cal(n-1)+cal(n-2))%1000000007;
        return memo[n];
    }
}