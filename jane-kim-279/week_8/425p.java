import java.util.ArrayDeque;

class Solution {
    static int n, m;
    static int[] start, end, lever;
    static char[][] map;
    static int[][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();       
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'S') {
                    start = new int[] {i, j};
                } else if (map[i][j] == 'E') {
                    end = new int[] {i, j};
                } else if (map[i][j] == 'L') {
                    lever = new int[] {i, j};
                }
            }
        }

        int startToLever = bfs(start, lever);
        int leverToEnd = bfs(lever, end);

        if (startToLever == -1 || leverToEnd == -1) {
            return -1;
        } else {
            return startToLever + leverToEnd;
        }
    }

    public static int bfs(int[] start, int[] end) {
        dist = new int[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        dist[start[0]][start[1]] = 1;
        q.add(start);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0]; int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 벗어난 경우
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                // 이미 방문한 경우
                if (dist[nx][ny] > 0) {
                    continue;
                }

                // 벽인 경우
                if (map[nx][ny] == 'X') {
                    continue;
                }

                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});

                // end 지점에 도달
                if (nx == end[0] && ny == end[1]) {
                    return dist[nx][ny] - 1;
                }
            }
        }

        return -1;
    }
}
