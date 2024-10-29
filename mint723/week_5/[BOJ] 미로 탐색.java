// https://www.acmicpc.net/problem/2178

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});

        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0], x = poll[1];

            if(y == N - 1 && x == M - 1) {
                answer = Math.min(answer, poll[2]);
            }else {
                for (int i = 0; i < 4; i++) {
                    int ny = y+dy[i];
                    int nx = x+dx[i];
                    if(isValid(ny, nx)) {
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny, nx, poll[2]+1});
                    }
                }
            }
        }

        System.out.println(answer);
        br.close();
    }

    static boolean isValid(int y, int x){
        return y >= 0 && y < N && x >= 0 && x < M && !visited[y][x] && map[y][x] == 1;
    }
}
