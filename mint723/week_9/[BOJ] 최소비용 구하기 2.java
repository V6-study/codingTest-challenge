// https://www.acmicpc.net/problem/11779
import java.util.*;
import java.io.*;

class Main {
    static int N;
    static List<int[]>[] graph;

    static class Node{
        int dest, cost;
        List<Integer> list;

        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
            list = new ArrayList<>();
            list.add(dest);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

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

        st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());

        Node dijkstra = dijkstra(startPoint, endPoint);

        StringBuilder sb = new StringBuilder();

        sb.append(dijkstra.cost).append('\n');

        List<Integer> list = dijkstra.list;

        sb.append(list.size()).append('\n');

        for(int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i)).append(' ');
        }

        System.out.println(sb);

        br.close();
    }

    static Node dijkstra(int start, int end){
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        Node node = new Node(start, 0);
        pq.offer(node);

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.dest == end && dist[cur.dest] == cur.cost)
                node = cur;

            if(visited[cur.dest])
                continue;

            visited[cur.dest] = true;

            for(int[] nextInfo : graph[cur.dest]){
                int next = nextInfo[0];
                int nextCost = nextInfo[1];

                if(dist[next] > cur.cost +  nextCost){
                    dist[next] = cur.cost + nextCost;
                    Node nextNode = new Node(next, dist[next]);
                    nextNode.list.addAll(cur.list);
                    pq.offer(nextNode);
                }
            }
        }

        return node;
    }
}
