import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, v;
    private static boolean[] visited;
    private static List<Integer>[] A;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        A = new List[n + 1];

        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }
        for (int i = 1; i < n + 1; i++) {
            Collections.sort(A[i]);
        }
        visited = new boolean[n + 1];
        dfs(v);
        visited = new boolean[n + 1];
        sb.append("\n");
        bfs(v);
        System.out.println(sb);

    }

    private static void dfs(int v) {
        sb.append(v + " ");
        visited[v] = true;
        for (int i : A[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur + " ");
            for (int i : A[cur]) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;

                }
            }
        }
    }
}
