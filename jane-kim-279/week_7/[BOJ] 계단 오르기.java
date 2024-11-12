import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N+5];
        int[] dp = new int[N+5];
        for (int i = 1; i <= N; i++) {
            int score = Integer.parseInt(br.readLine());
            stairs[i] = score;
        }
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i];
            // System.out.println(dp[i] + ": max(" + dp[i-3] + "+ " + stairs[i-1] + ", " + dp[i-2] + ") + " + stairs[i]);
        }
        System.out.println(dp[N]);
    }
}
