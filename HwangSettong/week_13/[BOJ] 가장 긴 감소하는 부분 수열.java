// https://www.acmicpc.net/problem/11722
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int cur = 0; cur <n; cur++) { // 현재 Index
            for(int pre = 0; pre < cur ; pre++) { // 이전 Index
                if(arr[cur] < arr[pre]) { // 이전 값 > 현재 값
                    // 저장된 현재 index 부분 수열 길이와 이전 index까지의 최장 부분 수열 길이 + 1 비교. 더 큰값 저장.
                    dp[cur] = Math.max(dp[pre]+1, dp[cur]); 
                }
            }
            res = Math.max(res, dp[cur]);

        }
        System.out.println(res);
    }
}
