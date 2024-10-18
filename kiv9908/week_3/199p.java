// https://www.acmicpc.net/problem/1158
// 요세푸스 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // n=7, k=3
        // 1 2 3 4 5 6 7
        // 4 5 6 7 1 2
        // 7 1 2 4 5

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.offer(i+1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!queue.isEmpty()) {
            int cnt = 1;
            while (cnt < k) {
                queue.offer(queue.pollFirst());
                cnt++;
            }
            sb.append(queue.pollFirst());
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);

        }
    }
