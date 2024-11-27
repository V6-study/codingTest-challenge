import java.util.*;
import java.io.*;

class Main {
    static int N,E;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new List[N+1];

        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new int[]{to, cost});
            graph[to].add(new int[]{from, cost});
        }
        st = new StringTokenizer(br.readLine());

        int target1 =  Integer.parseInt(st.nextToken());
        int target2 =  Integer.parseInt(st.nextToken());

        int[] results = getResults(target1, target2);

        if(results[0] == Integer.MAX_VALUE && results[1] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(results[0], results[1]));
        }

        br.close();
    }

    static int[] getResults(int target1, int target2) {
        int sep1 = dijkstra(1, target1);
        int sep2 = dijkstra(target1, target2);
        int sep3 = dijkstra(target2, N);

        int sep4 = dijkstra(1, target2);
        int sep5 = dijkstra(target2, target1);
        int sep6 = dijkstra(target1, N);

        int[] arr = new int[2];

        if(sep1 == Integer.MAX_VALUE || sep2 == Integer.MAX_VALUE || sep3 == Integer.MAX_VALUE)
            arr[0] = Integer.MAX_VALUE;
        else
            arr[0] = sep1 + sep2 + sep3;

        if(sep4 == Integer.MAX_VALUE || sep5 == Integer.MAX_VALUE || sep6 == Integer.MAX_VALUE)
            arr[1] = Integer.MAX_VALUE;
        else
            arr[1] = sep4 + sep5 + sep6;
        return arr;
    }

    static int dijkstra(int startPoint, int endPoint){
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startPoint] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });

        pq.offer(new int[]{startPoint, 0});

        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            int cur = poll[0];
            int curCost = poll[1];

            if(visited[cur])
               continue;

            visited[cur] = true;

            for(int[] info : graph[cur]){
                int next = info[0];
                int nextCost = info[1];
                if(dist[next] > curCost + nextCost){
                    dist[next] = curCost + nextCost;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        return dist[endPoint];
    }
}
