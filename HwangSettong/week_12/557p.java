// https://school.programmers.co.kr/learn/courses/30/lessons/62050
import java.util.*;
class Solution {
    int[][] land;
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    boolean[][] visited;
    int remain; // 남은 탐색 칸 수
    PriorityQueue<int[]> next = new PriorityQueue<>((o1,o2)->o1[2] - o2[2]); // 사다리 비용 오름차순
    
    
    void bfs(int r, int c, int height){
        Queue<int[]> path  = new LinkedList<>();
        path.offer(new int[] {r,c});
        
        while(!path.isEmpty()){
            int[] cur = path.poll();
            if(visited[cur[0]][cur[1]]) continue; // 방문한 칸이면 continue 
            visited[cur[0]][cur[1]] = true; // 방문 표시
            remain--; //남은 탐색 칸 수 -1
            
            for(int i = 0; i<4; i++){
                // 다음 탐색 r, c
                r = cur[0] + dr[i];
                c = cur[1] + dc[i];
                if(r<0||c<0||r>=land.length||c>=land.length) continue; // r,c 가 land 범위 넘으면 continue
                int cost = Math.abs(land[cur[0]][cur[1]]-land[r][c]); // cost: 현재 칸과 다음 칸 높이 차 구하기
                if(cost <= height){ // 사다리 없이 탐색 가능하면 path에 add
                    path.offer(new int[] {r,c});
                }else if(!visited[r][c]){ // 사다리 필요한 구간이면 next에 add
                    next.offer(new int[] {r,c, cost});
                }
            }
        }
    }
    
    
    public int solution(int[][] land, int height) {
        this.land = land;
        visited = new boolean[land.length][land.length];
        remain = land.length*land.length;
        int answer = 0;
        
        int[] start = {0,0,0}; // {r, c, cost}
        while(start != null && remain>0){
            bfs(start[0], start[1], height); // bfs 탐색 호출
            if(start != null && remain>0){ // 더 탐색할 수 있으면 next에서 다음 탐색 출발지 구하기
                while(!next.isEmpty() && visited[next.peek()[0]][next.peek()[1]]){ // next에서 방문한 적 없는 칸이 나올때까지 poll
                    next.poll();
                }
                start = next.poll(); // 다음 탐색 칸 교체
                answer += start[2]; // 사다리 비용 더해주기
            }
        }
        return answer;
    }
}
