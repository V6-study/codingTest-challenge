// https://www.acmicpc.net/problem/1753
import java.io.*;
import java.util.*;


class Node{
    int idx;
    int cost;
    public Node(int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }
}

public class Main {
    static int n, e; // n:노드 수, e:간선 수
    static ArrayList<Node>[] graph;
    static Integer[] dist; // 최단 비용 저장
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost); // 앞으로 방문 경로



    static void dijkstra(int start){
        dist[start] = 0;
        pq.add(new Node(start, 0)); // 시작노드 경로에 추가
        Node node;
        int nextCost;

        while(!pq.isEmpty()){
            node = pq.poll();
            if(node.cost > dist[node.idx]) continue; // 현재 노드 cost가 dist에 저장된 cost보다 크면 continue
            if(graph[node.idx]== null) { continue; } // 인접 노드 없으면 continue
            for (Node next : graph[node.idx]) {
                nextCost = dist[node.idx] + next.cost; // 비용 계산
                if (dist[next.idx] == null || dist[next.idx] > nextCost) { // 방문한 적 없거나, 계산한 비용이 최소비용이면
                    dist[next.idx] = nextCost; // 최소비용 저장
                    pq.add(new Node(next.idx, nextCost)); // 방문경로 추가
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 노드 수
        e = Integer.parseInt(st.nextToken()); // 간선 수
        int start = Integer.parseInt(br.readLine()); // 시작 노드
        graph = new ArrayList[n+1];
        dist = new Integer[n+1];




        // graph 만들어주기. 두 정점 사이에 여러 간선이 존재할 수도 있으니 최소 값을 담기.
        int u, v, w;
        Node node;
        ArrayList<Node> nodes;
        for (int i = 0; i <e; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            if(graph[u] == null){
                graph[u] = new ArrayList<Node>();
            }
            graph[u].add(new Node(v, w));
        }


        // 다익스트라 탐색
        dijkstra(start);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=n; i++){
            sb.append((dist[i] == null? "INF" : dist[i])+"\n");
        }
        System.out.println(sb);
    }
}
