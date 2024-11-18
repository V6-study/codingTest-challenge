import java.util.*;

public class Main {
    static int N, K;
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
    }

    public static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(N);
        time[N] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            // 순간이동 (0초)
            if (current * 2 <= max && time[current * 2] > time[current]) {
                time[current * 2] = time[current];
                q.offerFirst(current * 2); // 순간이동은 우선 처리
            }

            // 걷기 (+1초)
            if (current + 1 <= max && time[current + 1] > time[current] + 1) {
                time[current + 1] = time[current] + 1;
                q.offer(current + 1);
            }

            if (current - 1 >= 0 && time[current - 1] > time[current] + 1) {
                time[current - 1] = time[current] + 1;
                q.offer(current - 1);
            }
        }
    }
}
