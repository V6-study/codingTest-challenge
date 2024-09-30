// 행렬의 곱셈
// https://school.programmers.co.kr/learn/courses/30/lessons/12949

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr2[0].length;
        int len = arr1[0].length;
        
        int[][] answer = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<len; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
