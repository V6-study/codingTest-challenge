import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Integer> result = new ArrayList<>();
    public int[] solution(String[][] places) {
        for (String[] place : places) {
            boolean check = true;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) == 'P') {
                        if (!bfs(i, j, place)) {
                            check = false;
                        }
                    }
                }
            }
            result.add(check ? 1 : 0);   
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }

    static boolean bfs(int i, int j, String[] place) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        boolean[][] visited = new boolean[5][5];
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    int diff = Math.abs(nx - i) + Math.abs(ny - j);

                    if (diff <= 2 && place[nx].charAt(ny) == 'O') {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    } else if (diff <= 2 && place[nx].charAt(ny) == 'P') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
