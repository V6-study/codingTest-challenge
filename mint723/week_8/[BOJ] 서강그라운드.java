// https://www.acmicpc.net/problem/14938

import java.util.*;
import java.io.*;

public class Main {
    static int n,m,r;
    static List<int[]>[] graph;
    static int[] scores;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n =Integer.parseInt(st.nextToken()); // 노드 개수
        m =Integer.parseInt(st.nextToken()); // 수색 범위
        r =Integer.parseInt(st.nextToken()); // 길의 개수

        scores = new int[n+1];
        graph = new List[n+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());;

            graph[from].add(new int[]{to, cost});
            graph[to].add(new int[]{from, cost});
        }

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dijkstra(i));
        }

        System.out.println(max);
    }

    static int dijkstra(int startNode){
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{startNode, 0});

        while(!pq.isEmpty()){
            int[] info = pq.poll();
            int cur = info[0];
            int curCost = info[1];

            if(visited[cur])
                continue;

            visited[cur] = true;

            for(int[] arr: graph[cur]){
                int next = arr[0];
                int nextCost = arr[1];
                if(dist[next] > curCost + nextCost){
                    dist[next] = curCost + nextCost;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        int sum = 0;

        for(int i=1; i<=n; i++){
            if(dist[i] <= m)
                sum += scores[i];
        }

        return sum;
    }
}
