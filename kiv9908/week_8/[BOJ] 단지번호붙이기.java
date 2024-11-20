import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Main {
    static boolean visited[][];
    static int n;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int groupCnt=0;
    static List<Integer> houseCntList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        visited = new boolean[n][n];
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!(visited[i][j]) && map[i][j] != 0) {
                    bfs(i, j);
                    groupCnt++;
                }
            }
        }
        Collections.sort(houseCntList);
        for (int i = 0; i < houseCntList.size(); i++) {
            sb.append(houseCntList.get(i)).append("\n");
        }
        System.out.println(groupCnt);
        System.out.println(sb);
    }

    private static void bfs(int startY, int startX) {
        Deque<int[]> queue = new ArrayDeque<>();
        visited[startY][startX] = true;
        queue.offer(new int[]{startY, startX});
        int houseCnt = 1;

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[1] + dx[i];
                int ny = now[0] + dy[i];
                if (nx < n && ny < n && nx >= 0 && ny >= 0) {
                    if (!visited[ny][nx] && map[ny][nx] != 0) {
                        queue.offer(new int[] {ny,nx});
                        visited[ny][nx] = true;
                        houseCnt++;
                    }
                }
            }
        }
        houseCntList.add(houseCnt);
    }
}
