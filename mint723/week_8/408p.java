// https://www.acmicpc.net/problem/1753

import java.util.*;
import java.io.*;

class Main {
    private static class Node{
        int dest, cost;
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        Node startNode = new Node(Integer.parseInt(br.readLine()), 0);

        boolean[] visited = new boolean[V+1];
        int[] dist = new int[V+1];

        // 인접 리스트 생성 및 초기화
        List<Node>[] adjList = new List[V+1];

        for(int i=1; i<=V; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[from].add(new Node(to, cost));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode.dest] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(startNode);

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visited[cur.dest])
                continue;

            visited[cur.dest] = true;

            for(Node next :adjList[cur.dest]){
                if(dist[next.dest] > cur.cost + next.cost){
                    dist[next.dest] = cur.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i< dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }else{
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}
