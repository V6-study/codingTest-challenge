import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    private static class Node{
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static int[] solution(int[][] graph, int start, int n) {
        // 인접 리스트를 저장할 Arraylist 배열 초기화
        ArrayList<Node>[] adList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adList[i] = new ArrayList<>();
        }

        // graph 정보를 인접리스트에 저장
        for (int[] edge : graph) {
            adList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        int[] dist = new int[n];
        // 모든 노드의 거리 값을 무한대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 시작 노드의 거리 값은 0으로 초기화
        dist[start] = 0;
        // 우선순위 큐를 생성하고 시작 노드를 삽입
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            // 현재 가장 거리가 짧은 노드를 가져옴
            Node now = pq.poll();
            if(dist[now.dest] < now.cost) continue;

            for (Node next : adList[now.dest]) {
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }

        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}};
        int start = 0;
        int n = 3;

        int[] answer = solution(graph,start,n);
        for (int i : answer) {
            System.out.print(i+" ");
        }

    }
}
