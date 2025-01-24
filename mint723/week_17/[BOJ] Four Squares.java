// https://www.acmicpc.net/problem/17626

import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j*j] + 1, dp[i]);
            }
        }

        System.out.println(dp[N]);

        br.close();
    }
}
