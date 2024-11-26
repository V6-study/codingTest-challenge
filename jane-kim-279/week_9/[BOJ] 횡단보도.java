import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Node>> graph;
    static long[] distance;

    static class Node implements Comparable<Node> {
        int index;
        long cost;

        public Node(int index, long cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        distance[1] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            
            if (curr.cost > distance[curr.index]) {
                continue;
            }

            for (Node next : graph.get(curr.index)) {
                long nextCost;
                if (next.cost >= curr.cost) {
                    nextCost = next.cost + 1;
                } else {
                    nextCost = ((long) Math.ceil(((double)curr.cost-next.cost)/M)) * M + next.cost + 1;
                }
                if (nextCost < distance[next.index]) {
                    distance[next.index] = nextCost;
                    pq.add(new Node(next.index, nextCost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, i));
            graph.get(b).add(new Node(a, i));
        }
        dijkstra();
        System.out.println(distance[N]);
    }
}
