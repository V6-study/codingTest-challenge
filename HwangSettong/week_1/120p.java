class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length]; // m x n, n x r 행렬을 곱하면 m x r 행렬이 나옴
		
		// answer[i][j] = arr1[i][0]*arr2[0][j] + arr1[i][1]*arr2[1][j] + ... + arr1[i][n]*arr2[n][j]  
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				for (int n = 0; n < arr2.length; n++) {
					answer[i][j] += arr1[i][n] * arr2[n][j]; 
				}
			}

		}
        return answer;
    }
}
