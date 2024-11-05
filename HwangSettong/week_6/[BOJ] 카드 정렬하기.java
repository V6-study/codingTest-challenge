// https://www.acmicpc.net/problem/1715
import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());

        // 우선순위큐를 이용하여 오름차순으로 값 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n = 0; n < N; n++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        // 우선순위 큐에 값이 1개 남을 때까지 가장 작은 값 두개를 더한 값을 우선순위 큐에 넣기.
        int answer = 0;
        while(pq.size() > 1) {
            int temp = pq.poll() + pq.poll();
            pq.offer(temp);
            answer += temp;
        }

        System.out.println(answer);
    }
}
