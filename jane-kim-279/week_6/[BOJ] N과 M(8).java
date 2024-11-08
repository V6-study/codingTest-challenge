import java.io.*;
import java.util.*;

public class baekjoon {
    static int N, M;
    static int[] numbers;
    // static boolean[] visited;
    static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        // visited = new boolean[N];
        arr = new int[M];    
        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int depth, int start) {
        if (depth == M) {
            for (int a : arr) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            arr[depth] = numbers[i]; 
            dfs(depth + 1, i);
        }
    }
}
