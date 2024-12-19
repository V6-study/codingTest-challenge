class Solution {
    public int[][] rotate90(int[][] arr) {
        int N = arr.length;
        int[][] rotatedArr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotatedArr[j][N - 1 - i] = arr[i][j];
            }
        }

        return arr;
    }

    public int[][] solution(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr = rotate90(arr);
        }
        return arr;
    }
}
