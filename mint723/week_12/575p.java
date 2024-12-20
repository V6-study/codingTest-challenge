import java.util.*;

class Solution {
    public static void main(String[] args){
        int[][] matrix1_1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2_1 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
        System.out.println(Arrays.deepToString(solution(matrix1_1, matrix2_1)));

        int[][] matrix1_2 = {
                {2, 4, 6},
                {1, 3, 5},
                {7, 8, 9}
        };
        int[][] matrix2_2 = {
                {9, 1, 2},
                {4, 5, 6},
                {7, 3, 8}
        };
        System.out.println(Arrays.deepToString(solution(matrix1_2, matrix2_2)));
    }

    static public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr2[0].length;
        int len = arr1[0].length;

        int[][] arr = new int[n][m];
        
        // 행렬 곱
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<len; k++){
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        int[][] result = new int[m][n];
        
        // 전치 행렬
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                result[i][j] = arr[j][i];
            }
        }

        return result;
    }
}
