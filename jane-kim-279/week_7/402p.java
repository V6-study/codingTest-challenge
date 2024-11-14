import java.io.*;
import java.util.*;

public class baekjoon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        boolean[] visited = new boolean[N+1];
        dfs(start, graph, visited);

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                System.out.println(0);
            }
        }
    }

    public static void dfs(int start, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        System.out.println(start);
        visited[start] = true;
        for (int next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }
}
