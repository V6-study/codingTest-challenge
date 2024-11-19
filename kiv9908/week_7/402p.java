import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    // 인접리스트
    static ArrayList<Integer>[] A;
    static int[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new int[N + 1];
        cnt = 1;

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 1; i < N+1; i++) {
            Collections.sort(A[i]);
        }
        
        BFS(R);
        for(int i = 1; i < N+1; i++){
            System.out.println(visited[i]);
        }
    }

    public static void BFS(int start) {
        // 탐색시 맨 처음 방문할 노드를 add 하고 방문 처리
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = cnt;

        // 큐가 비어 있지 않은 동안 반복
        while(!queue.isEmpty()) {
            // 큐에 있는 원소 중 가장 먼저 추가된 원소를 poll
            int now = queue.poll();
            for(int next : A[now]){
                if(visited[next]==0){ // 방문하지 않은 인접한 노드인 경우
                    queue.add(next); // 큐에 넣고 방문처리
                    cnt++;
                    visited[next] = cnt;
                }
            }
        }


    }
}
