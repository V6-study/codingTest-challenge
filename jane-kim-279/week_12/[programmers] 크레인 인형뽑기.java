import java.util.*;

class Solution {
    static int N;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();

    public static boolean checkStack() {
        if (stack.size() >= 2) {
            int last = stack.pollLast();
            int secondLast = stack.pollLast();
            if (last == secondLast) {
                return true;
            } else {
                stack.addLast(secondLast);
                stack.addLast(last);
                return false;
            }
        }
        return false;
    }

    public int solution(int[][] board, int[] moves) {
        N = board.length;
        int answer = 0;

        for (int move : moves) {
            int col = move - 1;
            for (int row = 0; row < N; row++) {
                if (board[row][col] != 0) {
                    stack.addLast(board[row][col]);
                    board[row][col] = 0;
                    if (checkStack()) {
                        answer += 2;
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
