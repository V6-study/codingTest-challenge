// https://www.acmicpc.net/problem/11055
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        int[] sums = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sums[i] = arr[i];
        }

        Arrays.fill(dp,1);

        for(int i=2; i<=N; i++){
            for (int j = 1; j < i; j++) {
                if(arr[i] > arr[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                    sums[i] = Math.max(sums[i], sums[j]+arr[i]);
                }
            }
        }

        System.out.println(Arrays.stream(sums).max().getAsInt());
        br.close();
    }
}
