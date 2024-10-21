// https://www.acmicpc.net/problem/9461

import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        
        dp[1] = 1;        dp[2] = 1;        dp[3] = 1;
        dp[4] = 2;        dp[5] = 2;        dp[6] = 3;
        dp[7] = 4;        dp[8] = 5;        dp[9] = 7;
        dp[10] = 9;
        
        for(int i=11; i<=100; i++){
            dp[i] = dp[i-1]+dp[i-5];
        }
       
        for(int i=0; i<T; i++){
           int n = Integer.parseInt(br.readLine());
           sb.append(dp[n]);
           if(i+1!=T)
               sb.append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
}
