import java.util.*;

class Solution {
    private static int[][] solution(int n) {
        int[][] snailArray = new int[n][n];
        int num = 1;

        int startRow = 0, endRow = n - 1;
        int startCol = 0, endCol = n - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                snailArray[startRow][i] = num++;
            }
            startRow++;

            for (int i = startRow; i <= endRow; i++) {
                snailArray[i][endCol] = num++;
            }
            endCol--;

            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i++) {
                    snailArray[endRow][i] = num++;
                }
                endRow--;
            }

            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    snailArray[i][startCol] = num++;
                }
                startCol++;
            }
        }
        return snailArray;
    }
}
