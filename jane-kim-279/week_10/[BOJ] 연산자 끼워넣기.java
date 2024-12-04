import java.io.*;
import java.util.*;

public class Main {
    static int N, minVal, maxVal;
    static int[] arr, op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 덧셈, 뺄셈, 곱셈, 나눗셈 개수
        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        minVal = Integer.MAX_VALUE;
        maxVal = Integer.MIN_VALUE;

        dfs(arr[0], 1);
        System.out.println(maxVal);
        System.out.println(minVal);
    }

    public static void dfs(int num, int idx) {
        // 종료 조건
        if (idx == N) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0:
                        dfs(num + arr[idx], idx + 1);
                        break;
                    case 1:
                        dfs(num - arr[idx], idx + 1);
                        break;
                    case 2:
                        dfs(num * arr[idx], idx + 1);
                        break;
                    case 3:
                        dfs(num / arr[idx], idx + 1);
                        break;
                }
                op[i]++;
            }
        }
    }
}
