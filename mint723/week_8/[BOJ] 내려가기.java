// https://www.acmicpc.net/problem/2096

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[][][] dp = new int[2][N][3]; // [0][i][j] = max [1][i][j] = min

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0][0] = map[0][0];
        dp[0][0][1] = map[0][1];
        dp[0][0][2] = map[0][2];

        dp[1][0][0] = map[0][0];
        dp[1][0][1] = map[0][1];
        dp[1][0][2] = map[0][2];

        for (int i = 1; i < N; i++) {
            dp[0][i][0] = Math.max(dp[0][i-1][0], dp[0][i-1][1]) + map[i][0];
            dp[0][i][1] = Math.max(dp[0][i-1][0], Math.max(dp[0][i-1][1], dp[0][i-1][2])) + map[i][1];
            dp[0][i][2] = Math.max(dp[0][i-1][1], dp[0][i-1][2]) + map[i][2];

            dp[1][i][0] = Math.min(dp[1][i-1][0], dp[1][i-1][1]) + map[i][0];
            dp[1][i][1] = Math.min(dp[1][i-1][0], Math.min(dp[1][i-1][1], dp[1][i-1][2])) + map[i][1];
            dp[1][i][2] = Math.min(dp[1][i-1][1], dp[1][i-1][2]) + map[i][2];
        }

        StringBuilder sb = new StringBuilder();

        sb.append(Arrays.stream(dp[0][N-1]).max().getAsInt())
                .append(" ")
                .append(Arrays.stream(dp[1][N-1]).min().getAsInt());
        System.out.println(sb);
    }
}
