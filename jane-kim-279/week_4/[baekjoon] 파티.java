import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<ArrayList<Node>> reverseGraph;

    static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 인접 리스트
        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();
        for (int i = 0; i <= N + 1; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(new Node(v, w));
            reverseGraph.get(v).add(new Node(u, w));
        }

        int[] toX = dijkstra(X, graph);
        int[] fromX = dijkstra(X, reverseGraph);

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, toX[i] + fromX[i]);
        }
        
        System.out.println(result);
    }

    static int[] dijkstra(int start, ArrayList<ArrayList<Node>> graph) {
        // 최소 시간 배열
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        // 우선순위 큐
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node current = q.remove();

            if (current.weight > distance[current.vertex]) continue;

            for (Node next : graph.get(current.vertex)) {
                int cost = next.weight + distance[current.vertex];

                if (cost < distance[next.vertex]) {
                    distance[next.vertex] = cost;
                    q.add(new Node(next.vertex, cost)); 
                }
            }
        }

        return distance;
    }
}
