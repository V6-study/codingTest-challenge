// https://github.com/retrogemHK/codingtest_java/blob/main/solution/44.java

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] board1 = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        System.out.println(Arrays.deepToString(solution(board1)));

        int[][] board2 = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.deepToString(solution(board2)));
    }

    static class Block{
        int i,j;
        public Block(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    static int[][] Board;

    static boolean isValid(int num, int row, int col){
        return !(inRow(num, row) || inCol(num, col) || inBox(num, row, col));
    }

    static boolean inRow(int num, int row){
        return Arrays.stream(Board[row]).anyMatch(n -> n == num);
    }

    static boolean inCol(int num, int col){
        for (int i = 0; i < 9; i++) {
            if(Board[i][col] == num) return true;
        }
        return false;
    }

    static boolean inBox(int num, int row, int col){
        int boxRow = (row/3) * 3;
        int boxCol = (col/3) * 3;

        for (int i = boxRow; i < boxRow+3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if(Board[i][j] == num){
                    return true;
                }
            }
        }
        return false;
    }

    static Block findEmptyPosition(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(Board[i][j] == 0)
                    return new Block(i, j);
            }
        }

        return null;
    }

    static boolean findSolution(){
        Block emptyPos = findEmptyPosition();
        if(emptyPos == null)
            return true;

        int row = emptyPos.i;
        int col = emptyPos.j;

        for (int i = 1; i <= 9; i++) {
            if(isValid(i, row, col)){
                Board[row][col] = i;
                if(findSolution()){
                    return true;
                }
            }
            Board[row][col] = 0;
        }
        return false;
    }

    static int[][] solution(int[][] board){
        Board = board;
        findSolution();
        return board;
    }
}
