import java.util.*;
import java.io.*;

public class Main
{        
    static int N, M;
    static boolean[] visit;
    static int[] permutation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        permutation = new int[M];
        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int p : permutation) {
                System.out.print(p + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                permutation[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
