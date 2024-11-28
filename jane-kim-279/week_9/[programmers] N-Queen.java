class Solution {
    static int[] board;
    static int answer;

    static void backTracking(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[row] = i;
            if (checkValid(row)) {
                backTracking(row + 1, n);
            }
        }
    }

    static boolean checkValid(int i) {
        for (int j = 0; j < i; j++) {
            if (board[i] == board[j]) return false;
            if (Math.abs(i - j) == Math.abs(board[i] - board[j])) return false;
        }
        return true;
    }

    public int solution(int n) {
        board = new int[n];
        backTracking(0, n);
        return answer;
    }
}
