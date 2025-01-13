// https://school.programmers.co.kr/learn/courses/30/lessons/12905
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        
        int[][] dp = new int[n][m];
        
        for(int i=0; i<n; i++){
            dp[i][0] = board[i][0];
            answer = Math.max(board[i][0], answer);
        }
        
        for(int i=0; i<m; i++){
            dp[0][i] = board[0][i];
            answer = Math.max(board[0][i], answer);
        }
        
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(board[i][j] == 1){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }

        return answer * answer;
    }
}
