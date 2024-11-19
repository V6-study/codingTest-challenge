https://school.programmers.co.kr/learn/courses/30/lessons/1844
import java.util.*;
import java.lang.*;
class Solution {
    int[][] map;
    int[][] answer;
    int ax, ay; // 도착지
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    void bfs(int[] info){
        Queue<int[]> path = new LinkedList<>(); // {x, y, length}
        path.add(info);
        
        int x, y;
        while(!path.isEmpty()){
            info = path.poll();
            x = info[0];
            y = info[1];
            // 막힌 경로면 continue
            if(x < 0 || y < 0 || x > ax || y > ay || map[x][y] == 0) continue;
            // 방문 전적이 있는데 최단 거리가 아니면 continue
            if(answer[x][y] != 0 && answer[x][y] <= info[2]) continue;
            
            // answer에 거리 저장
            answer[x][y] = info[2]; 
            // 다음 방문 경로 담기
            for(int i=0; i<4; i++){
                path.offer(new int[] {x+dx[i], y+dy[i], info[2]+1});
            }
        }
    }
    
    public int solution(int[][] maps) {
        // 변수 초기화
        map=maps;
        ax = maps.length-1;
        ay = maps[0].length-1;
        answer = new int[ax+1][ay+1];
        
        // bfs 함수 호출
        bfs(new int[] {0, 0, 1});
        
        return answer[ax][ay] == 0 ? -1 : answer[ax][ay];
    }
}

