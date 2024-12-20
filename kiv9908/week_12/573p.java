public class Solution {

    private static int[][] rotate90(int[][] arr) {
        int n = arr.length;
        int[][] rotatedArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedArr[j][n - 1 - i] = arr[i][j];
            }
        }
        return rotatedArr;
    }

    private static int[][] solution(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr = rotate90(arr);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int[][] answer = solution(arr,1);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
