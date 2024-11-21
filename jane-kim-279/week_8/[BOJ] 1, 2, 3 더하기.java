import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] problem = new int[T];
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            problem[t] = N;
        }
        for (int i = 0; i < T; i++) {
            int n = problem[i];
            int[] dp = new int[n+5];
            dp[1] = 1; dp[2] = 2; dp[3] = 4;
            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            System.out.println(dp[n]);
        }
    }
}
