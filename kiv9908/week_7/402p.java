import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<Integer>[] A;
    private static int[] visited;
    private static int cnt;

    private static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());


        A = new ArrayList[N + 1];
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

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(A[i]);
        }

        visited = new int[N + 1];
        answer = new ArrayList<>();

        cnt = 1;
        DFS(R);

        for (int i = 1; i < N + 1; i++) {
            System.out.println(visited[i]);
        }


    }

    private static void DFS(int now) {
        visited[now] = cnt;
        for (int next : A[now]) {
            if (visited[next] == 0) {
                cnt++;
                DFS(next);
            }

        }


    }
}
