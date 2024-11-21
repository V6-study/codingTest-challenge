// https://www.acmicpc.net/problem/9465
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // testcase
        StringBuilder result = new StringBuilder(); // answer

        int n;
        int[][] arr;
        for (int t = 0; t < T; t++) {
            // n 입력받고 2*n 배열 만들어주기
            n = Integer.parseInt(br.readLine());
            arr = new int[2][n];
            arr[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 최대값 구하여 result에 append
            result.append(solution(arr, n) + "\n");
        }
        System.out.println(result);
    }


    /*
     arr[0][i]는 arr[1][i-2]와 arr[1][i-1] 값 중 더 큰 값을 더한 값.
     arr[1][i]는 arr[0][i-2]와 arr[0][i-1] 값 중 더 큰 값을 더한 값.
     마지막 arr[0][n-1], arr[1][n-1] 중 더 큰 값을 반환하면 됨.
     */
    static int solution(int[][] arr, int n){
        if(n > 1) {
            arr[0][1] = arr[0][1] + arr[1][0];
            arr[1][1] = arr[1][1] + arr[0][0];

            for (int i = 2; i < n; i++) {
                arr[0][i] += Math.max(arr[1][i - 1], arr[1][i - 2]);
                arr[1][i] += Math.max(arr[0][i - 1], arr[0][i - 2]);
            }
        }
        return Math.max(arr[0][n-1], arr[1][n-1]);
    }
}
