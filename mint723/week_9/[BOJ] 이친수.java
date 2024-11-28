// https://www.acmicpc.net/problem/2193

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        // dp[2] = 1; 10
        // dp[3] = 2; 101 100
        // dp[4] = 3; 1010 1000 1001
        // dp[5] = 5; (dp[4] 0 0 0 + dp[3] 01 01) -> dp[n] = dp[n-1] + dp[n-2] n-1에 0을 붙이는 경우 n-2에 01 붙이는 경우

        for(int i=2; i<=N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);
        br.close();
    }
}
