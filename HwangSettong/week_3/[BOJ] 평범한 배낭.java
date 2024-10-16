//https://www.acmicpc.net/problem/12865
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[NK[1]+1];
        int max = 0;
        for(int n = 0; n < NK[0]; n++){
            int[] wv = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(wv[0] <= NK[1]){
                for(int w = NK[1] - wv[0]; w > 0; w--){
                    dp[w+wv[0]] = Math.max(dp[w] + wv[1], dp[w+wv[0]]);
                    max = Math.max(max, dp[w+wv[0]]);
                }
                dp[wv[0]] = Math.max(dp[wv[0]], wv[1]);
                max = Math.max(max, dp[wv[0]]);
            }
        }
        System.out.println(max);
    }
}
