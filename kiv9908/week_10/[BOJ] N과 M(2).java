import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        answer = new int[m];
        int depth = 0;
        int start = 1;
        dfs(start, depth);
        System.out.println(sb);
    }

    private static void dfs(int start, int depth) {
        if (m == depth) {
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n + 1; i++) {
            if(!visited[i]){
                visited[i] = true;
                answer[depth] = i;
                dfs(i+1,depth + 1);
                visited[i] = false;
            }

        }
    }
}
