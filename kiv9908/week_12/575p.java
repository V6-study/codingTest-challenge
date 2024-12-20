public class Solution {
    private static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    private static int[][] transposeMatrix(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    private static int[][] solution(int[][] matrix1, int[][] matrix2) {
        int[][] multiplied = multiplyMatrix(matrix1, matrix2);
        return transposeMatrix(multiplied);
    }

    public static void main(String[] args) {
        int[][] answer = solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][] {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}});
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
