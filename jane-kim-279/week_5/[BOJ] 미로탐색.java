import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 배열
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs(0, 0));
    }
    
    static int bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY, 1)); // 시작점도 카운트에 포함
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            
            if(current.x == N-1 && current.y == M-1) {
                return current.distance;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, current.distance + 1));
                }
            }
        }
        
        return -1; // 도달할 수 없는 경우 (문제 조건상 발생하지 않음)
    }
    
    static class Point {
        int x, y, distance;
        
        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
