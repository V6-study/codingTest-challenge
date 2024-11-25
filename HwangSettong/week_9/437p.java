// https://school.programmers.co.kr/learn/courses/30/lessons/67259
import java.util.*;

class Solution {
    int[][] d = {{0,1}, {1,0}, {0,-1}, {-1,0}}; //{dx,dy}
    int answer = Integer.MAX_VALUE; // 문제 답
    int n; // N
    int[][] map; // 도면
    int[][] visited; // 방문한 길 최소 cost
    
    
    int bfs(){ 
        // path : {x, y, dx, dy, cost}.
        Queue<int[]> path = new LinkedList<>();
        path.offer(new int[] {0,0,0,0,0}); // path에 출발지 add
        int x, y, cost;
        while(!path.isEmpty()){
            int[] cur = path.poll();
            // 도착지에 도달하면 answer update 후 continue;
            if(cur[0] == n && cur[1] == n){ 
                answer = Math.min(cur[4], answer);
                continue;
            }
            // 방문한 적 있을 때, visited의 다음 경로 cost 최대값이 현재의 다음 경로 cost 최소값보다 작으면 탐색 의미 없으므로 continue
            if(visited[cur[0]][cur[1]] != 0 && visited[cur[0]][cur[1]]+600 <= cur[4]+100){
                continue;
            }
            visited[cur[0]][cur[1]] = cur[4]; // 방문 표시
            
            
            
            for(int i = 0; i<4; i++){
                x = cur[0] + d[i][0];
                y = cur[1] + d[i][1];
                cost = cur[4] + 100;
                // 갈 수 없는 위치이면 continue;
                if(x<0|| x>n || y<0 || y>n || map[x][y] == 1){
                    continue;
                }
                // path에 경로 담기. 방향 꺾으면 코너 비용 추가
                if((cur[2]==0&&cur[3]==0)||(d[i][0]==cur[2]&&d[i][1]==cur[3])){
                    path.offer(new int[] {x, y, d[i][0], d[i][1], cost});
                }else{
                    path.offer(new int[] {x, y, d[i][0], d[i][1], cost+500}); 
                }
                               
            }
            
            
        }
        return 0;
        
    }
    
    public int solution(int[][] board) {
        map = board;
        n = board.length -1;
        visited = new int[n+1][n+1];
        bfs();
        return answer;
    }
}
