// https://www.acmicpc.net/problem/24444
import java.io.*;
import java.util.*;

public class Main {
    static int N, M; // N: 노드 수, M: 간선 수
    static PriorityQueue<Integer>[] map; // 노드(index)와 이어진 노드들 저장
    static int[] order; // 노드(index) 순회 순서 저장
    static boolean[] visited; // 노드(index)방문 여부
    static int cnt = 1; // 순서

    static void bfs(int idx){
        Queue<Integer> path = new LinkedList<>();
        path.offer(idx);

        int cur, next;
        while(!path.isEmpty()){ // path에 저장된 경로를 다 돌아야 함.
            cur = path.poll();
            if(visited[cur]) continue; // 이미 방문한 노드면 continue
            order[cur] = cnt++;
            visited[cur] = true;
            // 인접 노드들 중 방문한 적 없고, path에 없는 노드들을 path에 저장
            while(map[cur] != null && !map[cur].isEmpty()){ 
                next = map[cur].poll();
                if(!visited[next]){
                    path.offer(next);
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        int R = input[2]; // 시작 노드

        // map 초기화
        map = new PriorityQueue[N + 1];
        for(int m=0; m<M; m++){
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(map[input[0]] == null) {
                map[input[0]] = new PriorityQueue<Integer>();
            }
            if(map[input[1]]== null) {
                map[input[1]] = new PriorityQueue<Integer>();
            }
            map[input[0]].add(input[1]);
            map[input[1]].add(input[0]);
        }
        br.close();

        // order , visited 초기화
        order = new int[N+1];
        visited = new boolean[N+1];

        // bfs 탐색
        bfs(R);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(order[i]+"\n");
        }
        System.out.println(sb);
    }
}
