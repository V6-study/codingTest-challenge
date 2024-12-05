import java.io.*;
import java.util.*;

public class Main {
    static class Player {
        int row;
        int col;
        int u;
        int life;
        int cnt;

        public Player(int row, int col, int u, int life, int cnt) {
            this.row = row;
            this.col = col;
            this.u = u;
            this.life = life;
            this.cnt = cnt;
        }
    }

    static Player player;
    static int N, H, D, answer;
    static char[][] graph;
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        graph = new char[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 'S') {
                    player = new Player(i, j, 0, H, 0);
                }
            }
        }

        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Player> queue = new LinkedList<>();
        queue.add(player);
        visited[player.row][player.col] = player.life;

        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Player curPlayer = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curPlayer.row + dx[i];
                int nc = curPlayer.col + dy[i];
                int nu = curPlayer.u;
                int nlife = curPlayer.life;
                int cnt = curPlayer.cnt;
                
                // 경계 바깥
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                // E에 도달
                if (graph[nr][nc] == 'E') {
                    min = Math.min(min, cnt + 1);
                    continue; // 계속 탐색한다
                }

                // 우산이면 내구도 갱신
                if (graph[nr][nc] == 'U') {
                    nu = D;
                }

                // . 인 경우
                if (nu != 0) {
                    nu--;
                } else {
                    nlife--;
                }

                // 죽는 경우 다시 탐색
                if (nlife == 0) continue;

                // 현재 요소가 이전에 방문했던 요소보다 진행을 더 할 수 있다 -> 현재 요소로 방문값 갱신
                if (visited[nr][nc] < nlife + nu) {
                    visited[nr][nc] = nlife + nu;
                    queue.add(new Player(nr, nc, nu, nlife, cnt + 1));
                }
            }
        } // while

        if (min == Integer.MAX_VALUE) answer = -1;
        else answer = min;
    }
}
