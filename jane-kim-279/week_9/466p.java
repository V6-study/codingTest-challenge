import java.util.*;

class Solution {

    static ArrayList<int[]> emptyList;

    static void findEmpty(int[][] board) {
        emptyList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    emptyList.add(new int[] {i, j});
                }
            }
        }
    }

    static boolean checkValid(int num, int row, int col, int[][] board) {
        // 같은 행에 num이 있는 경우
        if (Arrays.stream(board[row]).anyMatch(n -> n == num)) return false;
        
        // 같은 열에 num이 있는 경우
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // 3 x 3 박스에 num이 있는 경우
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        
        return true;
    }

    static boolean backtrack(int idx, int[][] board) {
        if (idx == emptyList.size()) return true;

        int[] pos = emptyList.get(idx);
        int row = pos[0], col = pos[1];

        for (int num = 1; num <= 9; num++) {
            if (checkValid(num, row, col, board)) {
                board[row][col] = num;
                if (backtrack(idx + 1, board)) return true;
                board[row][col] = 0;
            }
        }

        return false;
    }

    public static int[][] solution(int[][] board) {
        findEmpty(board);
        backtrack(0, board);
        return board;
    }
}
