import java.util.*;

class Solution {
    static int N, answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static class Node implements Comparable<Node> {
        int x, y, cost;
        
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public int solution(int[][] land, int height) {
        N = land.length;
        answer = 0;
        visited = new boolean[N][N];

        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visited[curr.x][curr.y]) {
                continue;
            }

            visited[curr.x][curr.y] = true;
            answer += curr.cost;

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    // 비용 처리
                    int heightDiff = Math.abs(land[nx][ny] - land[curr.x][curr.y]);
                    int newCost = heightDiff > height ? heightDiff : 0;
                    pq.offer(new Node(nx, ny, newCost));
                }
            }
        }
        
        return answer;
    }
}
