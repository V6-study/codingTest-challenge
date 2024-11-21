// https://www.acmicpc.net/problem/1916

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<int[]>[] graph = new List[N+1];
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new int[]{to, cost});
        }

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        dist[startNode] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{startNode, 0});

        while(!pq.isEmpty()){
            int[] curInfo = pq.poll();
            int cur = curInfo[0];
            int curCost = curInfo[1];

            if(visited[cur])
                continue;

            visited[cur] = true;

            for(int[] nextInfo : graph[cur]){
                int next = nextInfo[0];
                int nextCost = nextInfo[1];

                if(dist[next] > curCost + nextCost){
                    dist[next] = curCost + nextCost;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        System.out.println(dist[endNode]);
    }
}
