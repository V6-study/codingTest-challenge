// https://www.acmicpc.net/problem/12852

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(N);

        int[] dp = new int[1000002];
        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            int tmp = dp[i - 1] + 1;
            if (i % 3 == 0)
                tmp = Math.min(dp[i / 3] + 1, tmp);
            if (i % 2 == 0)
                tmp = Math.min(dp[i / 2] + 1, tmp);
            dp[i] = tmp;
        }

        System.out.println(dp[N]); // 횟수 출력

        while (N > 1) {
            //N = i으로 들어왔을 때 dp[i-1] dp[i/2] dp[i/3] 끼리 비교되어야 함
            int tmp = N - 1;
            if (N % 3 == 0 && dp[N / 3] < dp[tmp])
                tmp = N / 3;
            if (N % 2 == 0 && dp[N / 2] < dp[tmp])
                tmp = N / 2;

            sb.append(" ").append(tmp);

            N = tmp;
        }

        System.out.println(sb);

        br.close();
    }
}
