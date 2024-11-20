import java.util.*;

public class Main {
    static int N, K, count;
    static int max = 100000;
    static int[] time;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        time = new int[max + 1];
        Arrays.fill(time, Integer.MAX_VALUE);

        bfs();
        System.out.println(time[K]);
        System.out.println(count);
    }

    public static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(N);
        time[N] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == K) {
                count++;
                continue; // 다른 경로도 확인
            }

            int[] nextPositions = {current * 2, current + 1, current - 1};
            for (int next : nextPositions) {
                if (next >= 0 && next <= max) {
                    if (time[next] > time[current] + 1) {
                        time[next] = time[current] + 1;
                        q.offer(next);
                    } else if (time[next] == time[current] + 1) {
                        q.offer(next);
                    }
                }
            }
        }
    }
}
