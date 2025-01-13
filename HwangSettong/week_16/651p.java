// https://school.programmers.co.kr/learn/courses/30/lessons/12905
class Solution{
    public int solution(int [][]board){
        int answer = 0;
        int[][] dp = new int[board.length][board[0].length];
        for(int row = 0; row<dp.length; row++){
            for(int col = 0; col<dp[0].length; col++){
                // 구간 합 구하기
                dp[row][col] += board[row][col];
                if(row != 0) dp[row][col] += dp[row-1][col];
                if(col != 0) dp[row][col] += dp[row][col-1];
                if(row != 0 && col != 0) dp[row][col] -= dp[row-1][col-1];

                // 현재 구간에서 가장 큰 정사각형 확인
                int n = Math.min(row,col)+1;
                while(n >= 0){
                    if(n*n <= answer) break;
                    int temp = dp[row][col];
                    if(col >= n && row >= n) temp += dp[row-n][col-n];
                    if(col >= n) temp -= dp[row][col-n];
                    if(row >= n) temp -= dp[row-n][col];
                    if(temp == n*n && temp > answer) answer = temp;
                    n--;
                }
            }
        }
        
        return answer;
    }
}
