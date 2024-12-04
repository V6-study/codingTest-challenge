import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static int[][] min;
    private static int[][] max;

    // 다이나믹 프로그래밍 : 이전 행의 결과 값을 가지고 현재 행을 계산할 수 있음
    private static void dp(int n){
        for (int i = 1; i < n; i++){
            // 이전 행의 계산 값 중 작은 값과 현재 행을 더함
            min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + map[i][0];
            min[i][1] = Math.min(min[i-1][0], Math.min(min[i-1][1], min[i-1][2])) + map[i][1];
            min[i][2] = Math.min(min[i-1][1], min[i-1][2]) + map[i][2];
            // 이전 행의 계산 값 중 큰 값과 현재 행을 더함
            max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + map[i][0];
            max[i][1] = Math.max(max[i-1][0], Math.max(max[i-1][1], max[i-1][2])) + map[i][1];
            max[i][2] = Math.max(max[i-1][1], max[i-1][2]) + map[i][2];
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // min, max, map 배열 초기화
        min = new int[n][3];
        max = new int[n][3];
        map = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }
        br.close();
        // min, max 배열 첫번째 행 채워주기
        for (int i = 0; i < 3; i++) {
            min[0][i] = map[0][i];
            max[0][i] = map[0][i];
        }

        dp(n); // dp 실행

        // 결과 출력
        System.out.println(Math.max(Math.max(max[n-1][0], max[n-1][1]), max[n-1][2]) + " " + Math.min(Math.min(min[n-1][0], min[n-1][1]), min[n-1][2]));


    }
}
