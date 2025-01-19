import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for (int j=0; j<N; j++) {
                int n = s.charAt(j)-'0';
                map[i][j] = n;
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            for (int j=0; j<N; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    list.add(dfs(new int[]{i,j}));
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    static int dfs(int[] info){
        int y = info[0];
        int x = info[1];

        int count = 1;

        visited[y][x] = true;

            for (int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny>=0 && nx>=0 && ny<N && nx <N && !visited[ny][nx] && map[ny][nx] == 1){
                count += dfs(new int[]{ny, nx});
            }
        }

        return count;
    }
}
