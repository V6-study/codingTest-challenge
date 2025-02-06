class Solution {
    public int solution(int[][] board, int[][] skills) {
        int n = board.length;
        int m = board[0].length;
        int[][] diff = new int[n + 1][m + 1];

        for (int[] skill : skills) {
            int type = skill[0];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            int degree = (type == 1) ? -skill[5] : skill[5];

            diff[r1][c1] += degree;
            diff[r1][c2 + 1] -= degree;
            diff[r2 + 1][c1] -= degree;
            diff[r2 + 1][c2 + 1] += degree;
        }

        // 가로 방향 누적합 적용
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        // 세로 방향 누적합 적용
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        // 살아있는 건물 개수 계산
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += diff[i][j];
                if (board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}
