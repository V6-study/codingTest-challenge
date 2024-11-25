// https://www.acmicpc.net/problem/1238

import java.util.*;
import java.io.*;

class Main {
    static int N;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수
        int X = Integer.parseInt(st.nextToken()); // 반환점

        graph = new List[N+1];

        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new int[]{to, cost});
        }

        int[] dist = new int[N+1];

        for (int i = 1; i <= N; i++) {
            dist[i] = dijkstra(i, X) + dijkstra(X, i);
        }

        System.out.println(Arrays.stream(dist).max().getAsInt());

        br.close();
    }

    static int dijkstra(int start, int end){
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] info = pq.poll();
            int cur = info[0];
            int curCost = info[1];

            if(visited[cur])
                continue;

            visited[cur] = true;

            for(int[] nextInfo : graph[cur]){
                int next = nextInfo[0];
                int nextCost = nextInfo[1];

                if(dist[next] > curCost +  nextCost){
                    dist[next] = curCost + nextCost;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        return dist[end];
    }
}
