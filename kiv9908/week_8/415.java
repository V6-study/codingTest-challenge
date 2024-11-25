// https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;

class Solution {

    static boolean[][] visited;
    static int[] dy = {1,-1,0,0}; // 하, 상, 좌, 우
    static int[] dx = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        int rows = maps.length; // 행
        int cols = maps[0].length; // 열
        visited = new boolean[rows][cols]; // visited 배열 초기화
        int answer = 0;

        // BFS 함수 호출
        BFS(0, 0, rows, cols, maps);
        
        // 끝 지점의 값이 -1이면 도달 불가능, 아니면 최단 거리를 반환
        answer = maps[rows-1][cols-1] == 1 ? -1 : maps[rows-1][cols-1];
        return answer;
    }
    
    private static void BFS(int startX, int startY, int rows, int cols, int[][] maps){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {startX, startY});
        visited[startX][startY] = true;

        // BFS 탐색
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            // 상 하 좌 우 탐색
            for (int i = 0; i < 4; i++) {
                int newX = now[0] + dy[i];
                int newY = now[1] + dx[i];

                // 범위 체크 및 방문 체크
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                    if (!visited[newX][newY] && maps[newX][newY] != 0) {
                        visited[newX][newY] = true;
                        maps[newX][newY] = maps[now[0]][now[1]] + 1; // 이전 칸의 거리 + 1
                        queue.add(new int[] {newX, newY});
                    }
                }
            }
        }
    }
}
