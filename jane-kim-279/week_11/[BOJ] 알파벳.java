import java.io.*;
import java.util.*;

public class Main {
    static int R, C, answer;
    static String[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static HashSet<String> set = new HashSet<>();

    public static void dfs(int x, int y, int count) {
        answer = Math.max(count, answer);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < R && 0 <= ny && ny < C && !visited[nx][ny]) {
                if (!set.contains(graph[nx][ny])) {
                    visited[nx][ny] = true;
                    set.add(graph[nx][ny]);
                    dfs(nx, ny, count + 1);
                    visited[nx][ny] = false;
                    set.remove(graph[nx][ny]);
                }
            }
        }
    }
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new String[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = String.valueOf(str.charAt(j));
            }
        }

        set.add(graph[0][0]);
        dfs(0, 0, 1);
        System.out.println(answer);
    }
}
