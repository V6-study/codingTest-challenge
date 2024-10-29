// https://school.programmers.co.kr/learn/courses/30/lessons/42898
import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        long[][] map = new long[n+1][m+1];
        for(int[] p : puddles){
            map[p[1]][p[0]] = -1;
        }
        map[0][1] = 1;
        for(int x = 1; x<=n; x++){
            for(int y = 1; y<=m; y++){
                if(map[x][y] != -1L) {
                        map[x][y] = (Math.max(0L, map[x][y-1]) + Math.max(0L, map[x-1][y]))%1000000007L;
                }
            }
        }
        return (int) Math.max(map[n][m],0);
    }
}
