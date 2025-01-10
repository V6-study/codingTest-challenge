// https://school.programmers.co.kr/learn/courses/30/lessons/12913
import java.util.*;

class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][1],Math.max(dp[i-1][2], dp[i-1][3])) + land[i][0];
            dp[i][1] = Math.max(dp[i-1][0],Math.max(dp[i-1][2], dp[i-1][3])) + land[i][1];
            dp[i][2] = Math.max(dp[i-1][0],Math.max(dp[i-1][1], dp[i-1][3])) + land[i][2];
            dp[i][3] = Math.max(dp[i-1][0],Math.max(dp[i-1][1], dp[i-1][2])) + land[i][3];
        }

        return Arrays.stream(dp[n-1]).max().getAsInt();
    }
}



