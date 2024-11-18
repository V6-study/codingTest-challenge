//https://www.acmicpc.net/problem/1916

import java.io.*;
import java.util.*;


class Node{
    int idx; // 도착노드
    int cost; // 비용
    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}

public class Main {
    static int start, end; // 출발노드, 목적지노드
    static ArrayList<Node>[] graph;
    static Integer[] dist;



    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost); // 방문할 노드
        pq.offer(new Node(start, 0)); // 출발 노드 추가
        dist[start] = 0; // 출발 노드 비용 추가

        while(!pq.isEmpty()){
            Node cur = pq.poll(); // 현재 노드
            if(cur.cost > dist[cur.idx]) continue; // 최소비용이 아니면 continue
            if(cur.idx == end) return; // 목적지 도착했으면 return
            if(graph[cur.idx] == null) continue; // 인접 노드 없으면 continue
            for(Node next : graph[cur.idx]){ // 인접 노드 순회
                int nextCost = dist[cur.idx] + next.cost; // 다음 노드 비용 계산
                if(dist[next.idx] == null || nextCost < dist[next.idx]){ // 저장된 최소비용보다 작으면
                    dist[next.idx] = nextCost; // 최소비용바꿔주고
                    pq.offer(new Node(next.idx, nextCost)); // 경로 추가
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드 개수
        int M = Integer.parseInt(br.readLine()); // 간선 개수
        graph = new ArrayList[N+1]; // 그래프 초기화
        dist = new Integer[N+1]; // 최소비용배열 초기화

        // 입력 받고 그래프 채우기
        StringTokenizer st;
        int s, e, c; // 출발지, 도착지, 비용
        for(int i = 0; i <M ; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(graph[s] == null) graph[s] = new ArrayList<>();
            graph[s].add(new Node(e, c));
        }

        // 출발노드, 도착노드 저장
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());


        // dijkstra 탐색
        dijkstra();

        // 결과 출력
        System.out.println(dist[end]);



    }
}
