import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int targetX;
    static int targetY;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    targetX = i;
                    targetY = j;
                }
            }
        }
        bfs(targetX,targetY);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j]==1){
                    sb.append("-1").append(" ");
                }else{
                    sb.append(map[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    private static void bfs(int targetX, int targetY) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{targetX, targetY});
        visited[targetX][targetY] = true;
        map[targetX][targetY] = 0;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<n && ny<m && nx>=0 && ny>=0){
                    if(map[nx][ny] != 0 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        map[nx][ny] = map[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}