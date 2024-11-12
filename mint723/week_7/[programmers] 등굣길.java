// https://school.programmers.co.kr/learn/courses/30/lessons/42898

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] map = new int[n+1][m+1];
        map[1][1] = 1; // 시작점
        
        for(int i=0; i<puddles.length; i++){
            map[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                // 현재 위치가 물에 잠기지 않았을 때
                if(map[i][j] != -1){
                    // 위쪽 길이 물에 잠기지 않았을 때
                    if(map[i-1][j] != -1){
                        map[i][j] = (map[i][j] + map[i-1][j]) % 1000000007;
                    }
                    // 왼쪽 길이 물에 잠기지 않았을 때
                    if(map[i][j-1] != -1){
                        map[i][j] = (map[i][j] + map[i][j-1]) % 1000000007;
                    }
                }
            }
        }
        return map[n][m];
    }
}
