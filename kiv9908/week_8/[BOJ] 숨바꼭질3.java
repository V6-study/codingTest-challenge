// https://www.acmicpc.net/problem/13549
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int[] times = new int[100001];
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        for (int i = 0; i < times.length; i++) {
            times[i] = Integer.MAX_VALUE;
        }

        System.out.println(bfs(N));
    }

    private static int bfs(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        times[start] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int point = now[0];
            int time = now[1];

            if (point == K) {
                return time;
            }

            // 순간이동 (0초)
            if (point * 2 <= 100000 && time < times[point * 2]) {
                times[point * 2] = time;
                pq.offer(new int[]{point * 2, time});
            }

            // 앞으로 이동 (+1초)
            if (point + 1 <= 100000 && time + 1 < times[point + 1]) {
                times[point + 1] = time + 1;
                pq.offer(new int[]{point + 1, time + 1});
            }

            // 뒤로 이동 (+1초)
            if (point - 1 >= 0 && time + 1 < times[point - 1]) {
                times[point - 1] = time + 1;
                pq.offer(new int[]{point - 1, time + 1});
            }
        }
        return -1;
    }
}