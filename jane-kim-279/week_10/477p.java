class Solution {
    static int[] queens;
    static int answer;

    static void backtrack(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (checkValid(row, col)) {
                queens[row] = col;
                backtrack(row + 1, n);
            }
        }
    }

    static boolean checkValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) return false;
            if (Math.abs(row - i) == Math.abs(col - queens[i])) return false;
        }
        return true;
    }

    public int solution(int n) {
        queens = new int[n];
        backtrack(0, n);
        return answer;
    }
}
