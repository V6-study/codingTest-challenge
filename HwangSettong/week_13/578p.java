public class Solution {
    int[][] solution(int n){
        int[][] res = new int[n][n];
        int startR = 0, endR = n-1, startC = 0, endC = n-1;
        int num = 1;

        while(num <= n*n){
            for(int c = startC; c <= endR; c++){
                res[startR][c] = num++;
            }
            startR++;
            for(int r=startR; r <= endR; r++){
                res[r][endC] = num++;
            }
            endC--;
            for(int c = endC; c >= startC; c--){
                res[endR][c] = num++;
            }
            endR--;
            for(int r = endR; r >= startR; r--){
                res[r][startC] = num++;
            }
            startC++;
        }
        return res;
    }
}
