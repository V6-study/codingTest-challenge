import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    // 인접리스트 생성
    static ArrayList<Integer>[] A;

    // 방문 확인
    static boolean[] visited;

    // 방문 숫자
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        // 인덱스 1부터 시작
        A = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<Integer>();
        }

        visited = new boolean[N + 1];

        // 인접리스트에 값 넣기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);

        }

        // 노드 1과 연결된 노드 개수 출력
        if (!visited[1]) {
            BFS(1);
        }
        System.out.println(count);

    }

    private static void BFS(int s) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        visited[s] = true;

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(int next : A[temp]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
    }

}