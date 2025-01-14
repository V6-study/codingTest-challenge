class Solution
{
    public int solution(int [][]board)
    {
        int n = board.length;
        int m = board[0].length;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 1) {
                    int up = board[i][j - 1];
                    int left = board[i - 1][j];
                    int upleft = board[i - 1][j - 1];

                    board[i][j] += Math.min(up, Math.min(left, upleft));
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        }

        return answer * answer;
    }
}
