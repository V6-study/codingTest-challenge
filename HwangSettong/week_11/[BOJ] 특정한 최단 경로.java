// https://www.acmicpc.net/problem/1504
import java.io.*;
import java.util.*;

public class Main {
    private static int N, E; // 정점, 간선 수
    private static Integer[][] map;
    private static int[] v; // 경유지

    private static Integer[] dijkstra(int node) {
        Integer[] dist = new Integer[N+1];
        HashSet<Integer> visited = new HashSet<>();
        dist[node] = 0;
        while (true) {
            visited.add(node);
            int cost = dist[node];
            int minValue = Integer.MAX_VALUE;
            int minIndex = node;
            for(int i = 1; i <= N; i++) {
                if(map[node][i] != null && ( dist[i]==null || dist[i]>cost + map[node][i])) {
                    dist[i] = cost + map[node][i];
                }
                if(!visited.contains(i) && dist[i] != null && minValue > dist[i]) {
                    minValue = dist[i];
                    minIndex = i;
                }
            }
            if(minIndex == node) break;
            node = minIndex;
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        // 정점 수, 간선 수, 간선 정보, 경유지 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new Integer[N+1][N+1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[a][b] = cost;
            map[b][a] = cost;
        }
        v = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 경유지 추가
        br.close();


        Integer[] from1 = dijkstra(1); // 1번 노드에서 출발할 때 최소 비용 배열
        Integer[] fromV1 = dijkstra(v[0]); // v1번 노드에서 출발할 때 최소 비용 배열
        Integer[] fromV2 = dijkstra(v[1]); // v2번 노드에서 출발할 때 최소 비용 배열

        // result1: 1 -> v1 -> v2 -> n 순서로 방문할 때 비용
        // result2: 1 -> v2 -> v1 -> n 순서로 방문할 때 비용
        int result1=-1, result2=-1;
        if(from1[v[0]] != null && fromV1[v[1]] != null && fromV2[N] != null) {
            result1 = from1[v[0]] + fromV1[v[1]] + fromV2[N];
        }
        if(from1[v[1]] != null && fromV2[v[0]] != null && fromV1[N] != null) {
            result2 = from1[v[1]] + fromV2[v[0]] + fromV1[N];
        }
        System.out.println((result1 == -1 ? (result2 == -1 ? -1 : result1) : Math.min(result1, result2))); // 경로 없으면 -1

    }
}
