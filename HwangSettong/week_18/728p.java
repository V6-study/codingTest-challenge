// https://school.programmers.co.kr/learn/courses/30/lessons/118668
import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxal=alp, maxco=cop;
        for(int[] p: problems){
            maxal = Math.max(maxal, p[0]);
            maxco = Math.max(maxco, p[1]);
        }
        
        int[][] dp = new int[maxal+1][maxco+1];
        Arrays.stream(dp).forEach(i -> Arrays.fill(i, 3151));
        dp[alp][cop] = 0;
        for(int al = alp; al<=maxal; al++){
            
            for(int co = cop; co<=maxco; co++){
                if(al<maxal) dp[al+1][co] = Math.min(dp[al+1][co], dp[al][co]+1); // 1시간 기다려서 alp 1 증가
                if(co<maxco) dp[al][co+1] = Math.min(dp[al][co+1], dp[al][co]+1); // 1시간 기다려서 cop 1 증가
                    
                for(int[] p:problems){
                    if(al < p[0] || co<p[1]) continue; // 문제 풀 자격이 안되면 continue
                    int a = Math.min(maxal, al+p[2]);
                    int c = Math.min(maxco, co+p[3]);
                    dp[a][c] = Math.min(dp[a][c], dp[al][co]+p[4]);
                }
                
                if(al == maxal && co == maxco) break;
            }
            
        }
        
        
        return dp[maxal][maxco];
    }
}
