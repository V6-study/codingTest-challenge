//https://www.acmicpc.net/problem/2015
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n, k 입력 받기(n:정수 수, k:합)
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0], k = nk[1];

        // 배열 입력 받기
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long sum = 0 ; // 현재 위치까지의 합
        HashMap<Long, Integer> cnt = new HashMap<>(); // sum의 등장 횟수를 저장
        cnt.put(0L, 1); // 처음 sum은 0
        long answer = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            // (sum - k)를 한 수가 한번 이상 등장했으면 해당 횟수만큼 answer에 추가.
            answer += cnt.getOrDefault(sum-k, 0);
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
        }
        System.out.println(answer);
    }
}
