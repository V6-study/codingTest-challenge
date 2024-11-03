// https://www.acmicpc.net/problem/2606

import java.io.*;
import java.util.*;

class Main {
    static int[][] map;
    static boolean[] visited;
    static int N, M;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine())+1; // 컴퓨터의 수
        M = Integer.parseInt(br.readLine()); // 직접 연결되어 있는 쌍의 수
        map = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(1);

        System.out.println(answer);
    }
    static void dfs(int pos){
        visited[pos] = true;
        for(int i=0; i<N; i++){
            if(i!=pos && map[pos][i] == 1 && !visited[i]){
                dfs(i);
                answer++;
            }
        }
    }
}
