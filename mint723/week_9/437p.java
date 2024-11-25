import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        
        int[][][] map = new int[n][n][4];
        
        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1}; 
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i<4; i++){
            q.offer(new int[]{0,0,i,0});
        }
        
        while(!q.isEmpty()){
            int[] info = q.poll();
            int y = info[0];
            int x = info[1];
            int dir = info[2];
            
            for(int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny >= 0 && nx >= 0 && ny <n && nx < n && board[ny][nx] == 0){
                    int cost;
                    if(dir == i){
                        cost = info[3] + 100;
                    }else{
                        cost = info[3] + 600;
                    }
                    
                    if(ny == n-1 && nx == n-1){
                        answer = Math.min(answer, cost);
                    }else if(map[ny][nx][i] == 0 || map[ny][nx][i] > cost){
                        q.offer(new int[]{ny, nx, i, cost});
                        map[ny][nx][i] = cost;
                    }
                }
            }
        }
        
        
        return answer;
    }
}
