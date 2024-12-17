// https://school.programmers.co.kr/learn/courses/30/lessons/62050
import java.util.*;

class Solution {
    public int solution(int[][] land, int height) {
        int answer = 0;
        int N = land.length;
        int M = land[0].length;
        int[] dy = {0,0,1,-1};
        int[] dx = {1,-1,0,0};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[2]-o2[2];
        });
        boolean[][] visited = new boolean[N][M];
            
        pq.offer(new int[]{0, 0, 0});
        
        while(!pq.isEmpty()){
            int[] info = pq.poll();
            int y = info[0];
            int x = info[1];
            int cost = info[2];
            
            if(visited[y][x])
                continue;
            
            visited[y][x] = true;
            answer += cost;
            
            for(int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny>=0 && nx>=0 && ny<N && nx<M){
                    int diff = Math.abs(land[y][x] - land[ny][nx]);
                    int nCost = diff<=height?0:diff;
                    pq.offer(new int[]{ny, nx, nCost});
                }
            }
        }
        
        
        return answer;
    }
}
