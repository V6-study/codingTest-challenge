// 전력망 둘로 나누기) https://school.programmers.co.kr/learn/courses/30/lessons/86971?language=java

import java.util.*;
class Solution {
    int[][] map;
    boolean[] visited;
    int cnt;
    int n;
    
    void dfs(int i){
        visited[i] = true; // 방문 표시
        cnt ++; // 재귀호출 될 때 마다 cnt+1 해주기
        for(int next=0; next<n+1; next++){
            // 이어져있고, 방문한 적 없는 네트워크면 재귀호출
            if(map[i][next] == 1 && !visited[next]){ 
                dfs(next);
            }
        }
    }
    
    
    public int solution(int n, int[][] wires) {
        // map, visited 초기화
        map = new int[n+1][n+1];
        visited = new boolean[n+1];
        this.n = n;
        
        // map 채우기
        for(int[] wire : wires){
            map[wire[0]][wire[1]] = 1;
            map[wire[1]][wire[0]] = 1;
        }
        
        int answer=100;
        
        // 전력망 하나씩 끊어서 두 전력망의 송전탑 개수 차이 구하기.
        for(int[] wire : wires){
            // wire[0]에서 wire[1]로 가는 전력망 끊기
            map[wire[0]][wire[1]] = 0;
            // dfs 호출
            cnt = 0; // cnt 초기화
            Arrays.fill(visited, false); // vistited 초기화
            dfs(wire[0]); // wire[0]이 있는 전력망 탐색
            
            // 두 전력망 송전탑 개수의 차(cnt와 n-cnt의 차) 구하고 answer값과 비교 후 변경
            answer = Math.min(answer, Math.abs(cnt-(n-cnt)));
            
            // wire[0]에서 wire[1]로 가는 전력망 다시 이어주기
            map[wire[0]][wire[1]] = 1;
        }
        
        return answer;
    }
}
