import java.util.*;

class Solution {
    static int answer, N;
    static ArrayList<Integer>[] graph; // ArrayList<Integer>를 자료형으로 하는 배열
    static boolean[] visited;

    public static int dfs(int v) {
        visited[v] = true;
        int cnt = 1;

        for (int next : graph[v]) {
            if (!visited[next]) {
                cnt += dfs(next);
            }
        }
        return cnt;
    }

    public int solution(int n, int[][] wires) {
        N = n;
        answer = Integer.MAX_VALUE;
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }

        for (int[] wire : wires) {
            graph[wire[0]].remove(Integer.valueOf(wire[1]));
            graph[wire[1]].remove(Integer.valueOf(wire[0]));

            visited = new boolean[N + 1];

            int cnt = dfs(1);
            int diff = Math.abs(cnt - (N - cnt));
            answer = Math.min(answer, diff);

            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        return answer;
    }
}
