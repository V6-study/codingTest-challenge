import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][M + 1];

        dfs(0);
        System.out.println(answer);
    }

    /*
     * 사각형마다 넴모가 있는 경우와 없는 경우를 dfs 돌며 답을 구한다
     * 
     * 오른쪽으로 한 칸씩 진행, 다음 줄로 진행
     */
 
    public static void dfs(int depth) {
        if (depth == N * M) {
            answer++;
            return;
        }
        
        int x = depth / M + 1;
        int y = depth % M + 1;

        if (map[x-1][y] && map[x][y-1] && map[x-1][y-1]) { // 2 x 2가 생기는 경우, 오른쪽 아래에 넴모를 놓지 않고 계속 탐색
            dfs(depth + 1);
        } else {                    // 2 x 2가 생기지 않는 경우, 오른쪽 아래에 넴모를 놓거나, 놓지 않아도 됨
            dfs(depth + 1);
            map[x][y] = true;
            dfs(depth + 1);
            map[x][y] = false;
        }
    }
}
