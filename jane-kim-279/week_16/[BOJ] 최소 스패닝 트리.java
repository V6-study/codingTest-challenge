import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    public static int[] parent;

    // Find 연산 (경로 압축)
    public static int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }


    // Union 연산산
    public static void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            parent[rootV] = rootU;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");
        int v = Integer.parseInt(first[0]);
        int e = Integer.parseInt(first[1]);

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            String[] next = br.readLine().split(" ");
            int src = Integer.parseInt(next[0]);
            int dest = Integer.parseInt(next[1]);
            int weight = Integer.parseInt(next[2]);
            edges.add(new Edge(src, dest, weight));
        }

        // 1. 간선 리스트를 가중치 기준으로 정렬
        Collections.sort(edges);

        // 2. Union-Find 초기화
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 3. MST 계산
        int edgeCount = 0;  // 최소 스패닝 트리에 포함된 간선 수
        long mstWeight = 0; // 최소 스패닝 트르의 가중치 합

        for (Edge edge : edges) {
            // 사이클이 생기지 않으면 간선 추가
            if (find(edge.src) != find(edge.dest)) {
                union(edge.src, edge.dest);
                mstWeight += edge.weight;
                edgeCount++;

                // 정점 V개일 때 간선이 V-1개가 되면 완성
                if (edgeCount == v -1) {
                    break;
                }
            }
        }

        System.out.println(mstWeight);
    }
}
