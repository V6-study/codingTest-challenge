// https://www.acmicpc.net/problem/9095
import java.io.*;

public class Main {
    static int[] dp = new int[11+1];
    static int dpFunction(int n){
        if(n > 3 &&  dp[n] == 0){
            dp[n] = dpFunction(n-1) + dpFunction(n-2) + dpFunction(n-3);
        }
        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            dpFunction(n);
            System.out.println(dp[n]);
        }

    }
}
