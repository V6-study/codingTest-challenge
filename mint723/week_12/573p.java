// https://github.com/retrogemHK/codingtest_java/blob/main/solution/59.java
import java.util.*;

class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] arr1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int n1 = 1;
        System.out.println(Arrays.deepToString(solution.solution(arr1, n1)));
        int[][] arr2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int n2 = 2;
        System.out.println(Arrays.deepToString(solution.solution(arr2, n2)));
    }

    static public int[][] solution(int[][] arr, int n) {

        for (int i = 0; i < n; i++) {
            arr = rotate(arr);
        }
        return arr;
    }

    static int[][] rotate(int[][] arr){
        int N = arr.length;
        int[][] newArr = new int[N][N];

        for(int i=0; i<N; i++){
            for (int j = 0; j < N; j++) {
                newArr[j][N-1-i] = arr[i][j];
            }
        }

        return newArr;
    }
}
