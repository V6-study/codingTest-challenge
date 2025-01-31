class Solution {
    public int[] solution(int[][] arr) {
        // 결과를 저장할 배열: [0의 개수, 1의 개수]
        int[] result = new int[2];
        compress(arr, 0, 0, arr.length, result);
        return result;
    }

    private void compress(int[][] arr, int x, int y, int size, int[] result) {
        // 현재 영역이 압축 가능한지 확인
        if (isUniform(arr, x, y, size)) {
            result[arr[x][y]]++; // 0 또는 1의 개수를 증가
            return;
        }

        // 압축 불가능하면 4등분으로 나눔
        int newSize = size / 2;
        compress(arr, x, y, newSize, result);                // 1사분면
        compress(arr, x + newSize, y, newSize, result);      // 2사분면
        compress(arr, x, y + newSize, newSize, result);      // 3사분면
        compress(arr, x + newSize, y + newSize, newSize, result); // 4사분면
    }

    private boolean isUniform(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false; // 다른 값이 있으면 압축 불가능
                }
            }
        }
        return true; // 모든 값이 동일하면 압축 가능
    }
}
