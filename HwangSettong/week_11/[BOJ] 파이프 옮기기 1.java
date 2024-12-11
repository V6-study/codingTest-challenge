// https://www.acmicpc.net/problem/17070
import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static int[][][] arr; // arr[x][y] = {가로, 세로, 대각선 경우의 수}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        arr = new int[n+1][n+1][3];
        for(int i = 0; i<n ; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(dp(n));
    }

    private static int dp(int n){
        arr[1][2][0] = 1;
        for(int x = 1; x <= n; x++){
            for(int y = 2; y <= n; y++) {
                if (map[x - 1][y - 1] == 1) continue; // 벽 건너뛰기
                arr[x][y][0] += arr[x][y - 1][0] + arr[x][y - 1][2];
                arr[x][y][1] += arr[x - 1][y][1] + arr[x - 1][y][2];
                // 대각선 방향의 결과가 있으려면 위, 왼쪽 방향도 비어있어야 함.
                if (map[x - 1][y - 2] + (x > 1 ? map[x - 2][y - 1] : 0) == 0)
                    arr[x][y][2] += arr[x - 1][y - 1][0] + arr[x - 1][y - 1][1] + arr[x - 1][y - 1][2];
            }
        }
        return arr[n][n][0]+arr[n][n][1]+arr[n][n][2];

    }

    // bfs 시간초과
    /*
    private static int bfs(int n){
        // {파이프 끝 x, 파이프 끝 y, 파이프 놓인 방향} (방향 0:가로, 1:세로, 2:대각선)
        Queue<int[]> path = new LinkedList<>();
        path.add(new int[] {0,1,0});
        int answer = 0;
        while(!path.isEmpty()){
            int[] cur = path.poll();
            if(cur[0]==n-1 && cur[1]==n-1){
                answer ++;
                continue;
            }
            // (이동방향 ↘)  ↘, ↓, → 방향이 벽이 아니어야 함.
            if(cur[0]+1<n && cur[1]+1<n && map[cur[0]+1][cur[1]+1]==0 && map[cur[0]][cur[1]+1]==0 && map[cur[0]+1][cur[1]]==0)
                path.offer(new int[] {cur[0]+1, cur[1]+1, 2});
            // (이동방향 →)  이전 이동 방향이 ↓가 아니어야 하고, → 방향이 벽이 아니어야 함.
            if(cur[2] != 1 && cur[1]+1 < n && map[cur[0]][cur[1]+1]==0)
                path.offer(new int[] {cur[0], cur[1]+1, 0});
            // (이동방향 ↓)  이전 이동 방향이 →가 아니어야 하고, ↓ 방향이 벽이 아니어야 함.
            if(cur[2] != 0 && cur[0]+1 < n && map[cur[0]+1][cur[1]]==0)
                path.offer(new int[] {cur[0]+1, cur[1], 1});
        }

        return answer;
    }
    */
}
