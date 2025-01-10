import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        // 미리 조합 값을 계산해두기 (재귀 시간 초과)
        int[][] dp = new int[31][31];
        dp[0][0] = 1;
        
        for(int i = 1; i <= 30; i++) {
            dp[i][0] = 1;  // nC0 = 1
            for(int j = 1; j <= i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(dp[m][n]).append('\n');
        }
        System.out.print(sb);
    }
}
