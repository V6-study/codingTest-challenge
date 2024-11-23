import java.util.*;

class Solution {
    static int n, answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][][] visited;  // [x][y][방향]

    static class Car implements Comparable<Car> {
        int x;
        int y;
        int cost;
        int dir;

        public Car(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }

        @Override
        public int compareTo(Car other) {
            return this.cost - other.cost;
        }
    }
    
    public static void bfs(int[][] board) {
        PriorityQueue<Car> pq = new PriorityQueue<>();
        pq.add(new Car(0, 0, 0, -1)); // 초기 방향 -1
        
        // 모든 위치의 모든 방향에 대해 최대값으로 초기화
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 4; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        while (!pq.isEmpty()) {
            Car current = pq.poll();

            if (current.x == n - 1 && current.y == n - 1) {
                answer = Math.min(answer, current.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) {
                    continue;
                }

                // 비용 계산
                int newCost = current.cost;
                if (current.dir == -1) {  // 시작점
                    newCost += 100;
                } else if (current.dir == i) {  // 직진
                    newCost += 100;
                } else {  // 코너
                    newCost += 600;
                }

                // 같은 위치, 같은 방향으로 도착했을 때 비용이 더 작은 경우에만 갱신
                if (visited[nx][ny][i] > newCost) {
                    visited[nx][ny][i] = newCost;
                    pq.add(new Car(nx, ny, newCost, i));
                }
            }
        }
    }
    
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        n = board.length;
        visited = new int[n][n][4];  // 3차원 배열
        bfs(board);
        return answer;
    }
}
