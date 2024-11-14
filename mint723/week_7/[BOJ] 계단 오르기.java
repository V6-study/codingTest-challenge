// https://www.acmicpc.net/problem/2579

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[301];
        int[] dp = new int[301];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = Math.max(arr[1], arr[0] + arr[1]);
        dp[2] = Math.max(arr[1] + arr[2], arr[0] + arr[2]);

        for (int i = 3; i < N; i++) {
            // 마지막 계단 기준
            // 직전 칸을 밟는 경우 = (n-3) + (n-1) + n
            // 전전 칸을 밟는 경우 = (n-2) + n
            dp[i] = Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2] + arr[i]);
        }

        System.out.println(dp[N-1]);
        br.close();
    }
}
