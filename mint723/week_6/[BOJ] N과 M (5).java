// https://www.acmicpc.net/problem/15654

import java.io.*;
import java.util.*;

class Main {
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static int[] answer;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new int[M];
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            answer[0] = arr[i];
            dfs(1);
            visited[i] = false;
        }
        System.out.println(sb);
    }

    static void dfs(int depth){
        if(depth == M){
            for (int n : answer) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                answer[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
