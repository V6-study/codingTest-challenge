import java.util.*;

class Solution {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] result = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public int[][] solution(int[][] matrix1, int[][] matrix2) {
        int[][] multiplied = multiply(matrix1, matrix2);

        int[][] transposed = transpose(multiplied);
        return transposed;
    }
}
