import java.util.*;

class Solution {
    int N, M, X, Y, R, C, K;
    int[][] map;
    StringBuilder sb;
    // d l r u
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    char[] dir = {'d','l','r','u'};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        sb = new StringBuilder();
        N = n; M = m; R = r; C = c; K = k;
        map = new int[N+1][M+1];

        // 남은 거리
        int minDist = Math.abs(r - x) + Math.abs(c - y);

        // 도달할 수 없으면
        if (minDist > k || (k - minDist) % 2 == 1) {
            return "impossible";
        }
        
        dfs(new int[]{x, y, 0}, new ArrayList<>());
        return sb.length() == 0 ? "impossible" : sb.toString();
    }
    
    void dfs(int[] info, List<Integer> history){
        if(sb.length()>0) return;
        
        int x = info[0];
        int y = info[1];
        
        int minDist = Math.abs(R - x) + Math.abs(C - y);
        
        int remainDist = K - info[2];
        
        if(minDist > remainDist || (remainDist - minDist) % 2 == 1)
            return;
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            int score = info[2] + 1;
            
            if(!isValid(nx, ny, score))
                continue;
            
            history.add(i);
            if(nx == R && ny == C && K == score && sb.length() == 0){
                for(int j=0; j<history.size(); j++){
                    sb.append(dir[history.get(j)]);
                }
                return;
            }else{
                dfs(new int[]{nx, ny, score}, history);
            }
            history.remove(history.size()-1);
        }
    }
    
    boolean isValid(int x, int y, int score){
        return(x>=1 && x<=N && y>=1 && y<=M && score <= K);
    }
}
