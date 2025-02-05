import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int targetA = alp;
        int targetC = cop;
        
        for(int[] problem : problems){
            targetA = Math.max(targetA, problem[0]);
            targetC = Math.max(targetC, problem[1]);
        }
        
        int[][] dp = new int[targetA+1][targetC+1];
        
        for(int[] arr : dp){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        
        dp[alp][cop] = 0;
        
        for(int i=alp; i<= targetA; i++){ // 알고력 범위
            for(int j=cop; j<= targetC; j++){ // 코딩력 범위
                if (i < targetA) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1); // 알고력 1 증가 == 시간 1
                }
                if (j < targetC) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1); // 코딩력 1 증가 == 시간 1
                }
                
                for(int[] problem : problems){
                    // 알고력과 코딩력이 조건 만족하는지 확인
                    if(i >= problem[0] && j >= problem[1]){
                        int nextA = Math.min(i + problem[2], targetA); // 알고력 증가
                        int nextC = Math.min(j + problem[3], targetC); // 코딩력 증가
                        
                        // 갱신
                        dp[nextA][nextC] = Math.min(dp[nextA][nextC], dp[i][j] + problem[4]);
                    }
                }
            }
        }
        
        return dp[targetA][targetC];
    }
}
