import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] answer,arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[m];
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int depth = 0;
        dfs(depth);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < n + 1; i++) {
                answer[depth] = arr[i];
                dfs(depth + 1);

        }
    }
}
