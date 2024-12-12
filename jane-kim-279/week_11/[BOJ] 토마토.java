import java.io.*;
import java.util.*;

public class Main {
    static int M, N, answer;
    static int[][] graph;
    static Queue<int[]> queue = new LinkedList<>();;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs();
        answer = 0;
        boolean checkTomato = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    checkTomato = true;
                    break;
                } 
                answer = Math.max(answer, graph[i][j]);
            }
            if (checkTomato) break;
        }
        if (checkTomato) System.out.println(-1);
        else System.out.println(answer - 1);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0]; int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = graph[x][y] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
