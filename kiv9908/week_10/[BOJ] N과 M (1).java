package week_10.N과M1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n+1];
        dfs(n, m, 0);
        System.out.println(sb);
    }

    private static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i < n+1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(n,m,depth+1);
                visited[i] = false;
            }
        }
    }
}
